package com.example.catalogsvc.controller;

import com.example.catalogsvc.manager.ProductManager;
import com.example.catalogsvc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatalogController {

    @Autowired
    private ProductManager manager;

    @GetMapping("/Product/GetProductsByUniqId")
    public Product getProductByUniqId() {
        return manager.getProductByUniqId();
    }

    @GetMapping("/Products/GetProductsBySku")
    public List<Product> getProductsBySku() {
        return manager.getProductsBySku();
    }
}
