package com.example.productsvc.manager;

import com.example.productsvc.model.Product;
import com.example.productsvc.model.Status;

import java.util.List;

public interface ProductManager {
    Product getAvailableProductByUniqId(String uniqId);
    List<Product> getAvailableProductsBySku(String uniqId);
    boolean getProductAvailability(String id);
}
