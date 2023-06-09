package com.example.inventorysvc.controller;

import com.example.inventorysvc.model.Status;
import com.example.inventorysvc.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
    @Autowired
    private AvailabilityService availabilityService;

    @GetMapping("/")
    public Status getProductStatus(String uniqId) {
        return availabilityService.getProductStatus(uniqId);
    }
}
