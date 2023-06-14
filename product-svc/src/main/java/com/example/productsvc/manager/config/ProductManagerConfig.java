package com.example.productsvc.manager.config;

import com.example.productsvc.manager.ProductManager;
import com.example.productsvc.manager.impl.ProductManagerImpl;
import com.example.productsvc.ri.catalog.CatalogServiceClient;
import com.example.productsvc.ri.inventory.InventoryServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductManagerConfig {

    @Bean
    public ProductManager productManager(CatalogServiceClient catalogClient, InventoryServiceClient inventoryClient) {
        return new ProductManagerImpl(catalogClient, inventoryClient);
    }
}
