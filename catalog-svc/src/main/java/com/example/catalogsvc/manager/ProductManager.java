package com.example.catalogsvc.manager;

import com.example.catalogsvc.model.Product;

import java.util.List;

public interface ProductManager {
    Product getProductByUniqId(String uniqId);
    List<Product> getProductsBySku(String sku);
}
