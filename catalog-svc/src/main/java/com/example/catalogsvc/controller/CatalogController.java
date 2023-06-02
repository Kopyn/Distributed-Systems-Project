package com.example.catalogsvc.controller;

import com.example.catalogsvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/")
    public String getProductsAvailability() {
        return repository.test();
    }
}
