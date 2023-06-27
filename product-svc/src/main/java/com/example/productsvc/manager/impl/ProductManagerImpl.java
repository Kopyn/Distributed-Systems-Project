package com.example.productsvc.manager.impl;

import com.example.productsvc.manager.ProductManager;
import com.example.productsvc.model.Product;
import com.example.productsvc.ri.catalog.CatalogServiceClient;
import com.example.productsvc.ri.inventory.InventoryServiceClient;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ProductManagerImpl implements ProductManager {

    private final CatalogServiceClient catalogServiceClient;
    private final InventoryServiceClient inventoryServiceClient;
    private final CircuitBreaker inventoryCircuitBreaker;
    private final CircuitBreaker catalogCircuitBreaker;

    public ProductManagerImpl(@Autowired CatalogServiceClient catalogClient,
                              @Autowired InventoryServiceClient inventoryClient,
                              @Autowired CircuitBreakerConfig circuitBreakerConfig) {
        catalogServiceClient = catalogClient;
        inventoryServiceClient = inventoryClient;

        CircuitBreakerRegistry circuitBreakerRegistry =
                CircuitBreakerRegistry.of(circuitBreakerConfig);

        inventoryCircuitBreaker =
                circuitBreakerRegistry.circuitBreaker("inventory-svc");

        catalogCircuitBreaker =
                circuitBreakerRegistry.circuitBreaker("catalog-svc");
    }

    @Override
    public Product getAvailableProductByUniqId(String uniqId) {
        boolean availability = isProductAvailable(uniqId);
        return availability ? getProduct(uniqId) : null;
    }

    @Override
    public List<Product> getAvailableProductsBySku(String sku) {
        List<Product> productsFound = getProducts(sku);
        return productsFound.stream()
                .filter(product -> isProductAvailable(product.getUniqId()))
                .collect(Collectors.toList());
    }

    private Product getProduct(String uniqId) {
        Supplier<Product> decoratedSupplier = CircuitBreaker.decorateSupplier(
                this.catalogCircuitBreaker, () -> catalogServiceClient.getProductDataById(uniqId));

        return Try.ofSupplier(decoratedSupplier)
                .recover(this::handleCatalogServiceUnavailable)
                .get();
    }

    private List<Product> getProducts(String sku) {
        Supplier<List<Product>> decoratedSupplier = CircuitBreaker.decorateSupplier(
                this.catalogCircuitBreaker, () -> catalogServiceClient.getProductDataBySku(sku));

        return Try.ofSupplier(decoratedSupplier)
                .recover(throwable -> List.of(handleCatalogServiceUnavailable(throwable)))
                .get();
    }

    private boolean isProductAvailable(String uniqId) {
        Supplier<Boolean> decoratedSupplier = CircuitBreaker.decorateSupplier(
                this.inventoryCircuitBreaker, () -> inventoryServiceClient.isProductAvailable(uniqId));

        return Try.ofSupplier(decoratedSupplier)
                .recover(this::handleInventoryServiceUnavailable)
                .get();
    }

    private boolean handleInventoryServiceUnavailable(Throwable throwable) {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Inventory service Unavailable");
    }

    private Product handleCatalogServiceUnavailable(Throwable throwable) {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Catalog service Unavailable");
    }
}
