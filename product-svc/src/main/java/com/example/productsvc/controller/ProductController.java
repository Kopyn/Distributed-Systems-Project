package com.example.productsvc.controller;

import com.example.productsvc.manager.ProductManager;
import com.example.productsvc.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductManager productManager;

    public ProductController(ProductManager manager) {
        productManager = manager;
    }

    @GetMapping("/getProductByUniqId")
    public Product getProductByUniqId(String uniqId) {
        return productManager.getAvailableProductByUniqId(uniqId);
    }

    @GetMapping("/getProductsBySku")
    public List<Product> getProdutsBySku(String sku) {
        return productManager.getAvailableProductsBySku(sku);
    }

}
