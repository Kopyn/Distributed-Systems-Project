package com.example.productsvc.ri.catalog;

import com.example.productsvc.model.Product;

import java.util.List;

public interface CatalogServiceClient {
    Product getProductDataById(String uniqId);
    List<Product> getProductDataBySku(String sku);
}
