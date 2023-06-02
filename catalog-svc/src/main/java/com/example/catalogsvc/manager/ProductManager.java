package com.example.catalogsvc.manager;

import com.example.catalogsvc.model.Product;

import java.util.List;

public interface ProductManager {
    String getRepoInfo();
    Product getProductByUniqId();
    List<Product> getProductsBySku();
}
