package com.example.inventorysvc.service.impl;

import com.example.inventorysvc.model.Status;
import com.example.inventorysvc.repository.AvailabilityRepository;
import com.example.inventorysvc.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;

public class AvailabilityServiceImpl implements AvailabilityService {

    @Autowired
    private AvailabilityRepository repository;

    @Override
    public Status getProductStatus(String productUniqId) {
        return repository.getProductStatus(productUniqId);
    }
}
