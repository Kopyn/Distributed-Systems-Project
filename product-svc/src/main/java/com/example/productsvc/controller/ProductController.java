package com.example.productsvc.controller;

import com.example.productsvc.manager.ProductManager;
import com.example.productsvc.model.Product;
import com.example.productsvc.model.Status;
import com.example.productsvc.ri.catalog.CatalogServiceClient;
import com.example.productsvc.ri.inventory.InventoryServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
//    @Autowired
    private final ProductManager productManager;

    public ProductController(ProductManager manager) {
        productManager = manager;
    }

    @GetMapping("/12")
    public Product getProductByUniqId(String uniqId) {
//        return catalogServiceClient.getProductDataById(uniqId);
        return productManager.getAvailableProductByUniqId(uniqId);
    }

    @GetMapping("/getAvailability")
    public boolean getAvailability(String uniqId) {
//        return catalogServiceClient.getProductDataById(uniqId);
        return productManager.getProductAvailability(uniqId);
    }

    @GetMapping("/")
    public List<Product> getProdutsBySku(String sku) {
//        return catalogServiceClient.getProductDataBySku(sku);
        return null;
    }

}
