package com.example.catalogsvc.manager.impl;

import com.example.catalogsvc.manager.ProductManager;
import com.example.catalogsvc.model.Product;
import com.example.catalogsvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductManagerImpl implements ProductManager {
    @Autowired
    private ProductRepository repository;
    public String getRepoInfo() {
        return repository.test();
    }

    public Product getProductByUniqId() {
        return null;
    }

    public List<Product> getProductsBySku() {
        return null;
    }
}
