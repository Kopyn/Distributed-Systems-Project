package com.example.catalogsvc.manager.impl;

import com.example.catalogsvc.manager.ProductManager;
import com.example.catalogsvc.model.Product;
import com.example.catalogsvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductManagerImpl implements ProductManager {
    @Autowired
    private ProductRepository repository;

    public Product getProductByUniqId(String uniqId) {
        return repository.getProductByUniqId(uniqId);
    }

    public List<Product> getProductsBySku(String sku) {
        return repository.getProductsBySku(sku);
    }
}
