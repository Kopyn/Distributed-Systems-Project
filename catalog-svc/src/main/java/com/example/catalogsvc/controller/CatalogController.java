package com.example.catalogsvc.controller;

import com.example.catalogsvc.manager.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {

    @Autowired
    private ProductManager manager;

    @GetMapping("/")
    public String getProductsAvailability() {
        return manager.getRepoInfo();
    }
}
