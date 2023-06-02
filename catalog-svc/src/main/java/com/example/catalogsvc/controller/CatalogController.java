package com.example.catalogsvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {
    @GetMapping("/")
    public String getProductsAvailability() {
        return "hello";
    }
}
