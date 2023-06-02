package com.example.catalogsvc.repository.impl;

import com.example.catalogsvc.model.Product;
import com.example.catalogsvc.repository.ProductRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductRepositoryImpl implements ProductRepository {

    private final ArrayList<Product> rows = new ArrayList<>();

    public ProductRepositoryImpl(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                rows.add(readProductFromLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Product readProductFromLine(String line) {
        return null;
    }

    @Override
    public String test() {
        return rows.toString();
    }
}
