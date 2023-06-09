package com.example.inventorysvc.repository.impl;

import com.example.inventorysvc.model.Status;
import com.example.inventorysvc.repository.AvailabilityRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AvailabilityRepositoryImpl implements AvailabilityRepository {

    private Map<String, Status> productAvailabilities;

    public AvailabilityRepositoryImpl(String filename) {
        productAvailabilities = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                productAvailabilities.put(line.split("\t")[0], Math.random() > 0.5 ? Status.AVAILABLE : Status.UNAVAILABLE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Status getProductStatus(String productUniqId) {
        return productAvailabilities.get(productUniqId);
    }
}
