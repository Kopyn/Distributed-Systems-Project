package com.example.productsvc.manager.impl;

import com.example.productsvc.manager.ProductManager;
import com.example.productsvc.model.Product;
import com.example.productsvc.ri.catalog.CatalogServiceClient;
import com.example.productsvc.ri.inventory.InventoryServiceClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ProductManagerImpl implements ProductManager {

    private CatalogServiceClient catalogServiceClient;
    private InventoryServiceClient inventoryServiceClient;

    public ProductManagerImpl(@Autowired CatalogServiceClient catalogClient,
                              @Autowired InventoryServiceClient inventoryClient) {
        catalogServiceClient = catalogClient;
        inventoryServiceClient = inventoryClient;
    }

    @Override
    public Product getAvailableProductByUniqId(String uniqId) {
        boolean availability = inventoryServiceClient.isProductAvailable(uniqId);
        return availability ? catalogServiceClient.getProductDataById(uniqId) : null;
    }

    @Override
    public List<Product> getAvailableProductsBySku(String sku) {
        return catalogServiceClient.getProductDataBySku(sku)
                .stream()
                .filter(product -> inventoryServiceClient.isProductAvailable(product.getUniqId()))
                .collect(Collectors.toList());
    }
}
