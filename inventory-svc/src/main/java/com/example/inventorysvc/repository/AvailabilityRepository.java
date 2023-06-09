package com.example.inventorysvc.repository;

import com.example.inventorysvc.model.Status;

public interface AvailabilityRepository {
    Status getProductStatus(String productUniqId);
}
