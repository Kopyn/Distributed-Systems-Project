package com.example.productsvc.ri;

import com.example.productsvc.ri.catalog.CatalogServiceClient;
import com.example.productsvc.ri.catalog.CatalogServiceClientImpl;
import com.example.productsvc.ri.inventory.InventoryServiceClient;
import com.example.productsvc.ri.inventory.InventoryServiceClientImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RiConfig {
    @Bean
    public CatalogServiceClient catalogServiceClient() {
        return new CatalogServiceClientImpl();
    }

    @Bean
    public InventoryServiceClient inventoryServiceClient() {
        return new InventoryServiceClientImpl();
    }
}
