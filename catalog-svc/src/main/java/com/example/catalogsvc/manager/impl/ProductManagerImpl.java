package com.example.catalogsvc.manager.impl;

import com.example.catalogsvc.manager.ProductManager;
import com.example.catalogsvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductManagerImpl implements ProductManager {
    @Autowired
    private ProductRepository repository;
    public String getRepoInfo() {
        return repository.test();
    }
}
