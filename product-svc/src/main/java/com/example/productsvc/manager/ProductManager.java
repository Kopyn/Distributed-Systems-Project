package com.example.productsvc.manager;

import com.example.productsvc.model.Product;

import java.util.List;

public interface ProductManager {
    Product getAvailableProductByUniqId(String uniqId);
    List<Product> getAvailableProductsBySku(String uniqId);
}
