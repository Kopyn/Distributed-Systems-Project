package com.example.inventorysvc.repository;


public interface AvailabilityRepository {
    boolean getProductStatus(String productUniqId);
}
