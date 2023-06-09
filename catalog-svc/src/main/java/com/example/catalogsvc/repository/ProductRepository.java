package com.example.catalogsvc.repository;

import com.example.catalogsvc.model.Product;

import java.util.List;

public interface ProductRepository {
    Product getProductByUniqId(String uniqId);

    List<Product> getProductsBySku(String sku);
}
