package com.example.productsvc.manager.impl;

import com.example.productsvc.manager.ProductManager;
import com.example.productsvc.model.Product;
import com.example.productsvc.model.Status;
import com.example.productsvc.ri.catalog.CatalogServiceClient;
import com.example.productsvc.ri.catalog.CatalogServiceClientImpl;
import com.example.productsvc.ri.inventory.InventoryServiceClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        return null;
    }

    @Override
    public List<Product> getAvailableProductsBySku(String uniqId) {
        return null;
    }

    @Override
    public boolean getProductAvailability(String id) {
        return inventoryServiceClient.isProductAvailable(id);
    }
}
