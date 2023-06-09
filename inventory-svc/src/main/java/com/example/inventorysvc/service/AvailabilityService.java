package com.example.inventorysvc.service;

import com.example.inventorysvc.model.Status;

public interface AvailabilityService {
    Status getProductStatus(String productUniqId);
}
