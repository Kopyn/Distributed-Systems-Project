package com.example.productsvc.manager.config;

import com.example.productsvc.manager.ProductManager;
import com.example.productsvc.manager.impl.ProductManagerImpl;
import com.example.productsvc.ri.catalog.CatalogServiceClient;
import com.example.productsvc.ri.inventory.InventoryServiceClient;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductManagerConfig {

    @Bean
    public ProductManager productManager(CatalogServiceClient catalogClient,
                                         InventoryServiceClient inventoryClient,
                                         CircuitBreakerConfig circuitBreakerConfig) {
        return new ProductManagerImpl(catalogClient, inventoryClient, circuitBreakerConfig);
    }
}
