package com.example.catalogsvc.controller;

import com.example.catalogsvc.manager.ProductManager;
import com.example.catalogsvc.model.Product;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
public class CatalogController {

    @Autowired
    private ProductManager manager;

    @GetMapping("/Product/GetProductByUniqId")
    public Product getProductByUniqId(@RequestParam String uniqId) {
        return manager.getProductByUniqId(uniqId);
    }

    @GetMapping("/Product/GetProductsBySku")
    public List<Product> getProductsBySku(@RequestParam String sku) {
        return manager.getProductsBySku(sku);
    }
}
