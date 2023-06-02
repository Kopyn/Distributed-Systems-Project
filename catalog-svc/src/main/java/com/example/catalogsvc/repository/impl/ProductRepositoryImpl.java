package com.example.catalogsvc.repository.impl;

import com.example.catalogsvc.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public String test() {
        return "hello1";
    }
}
