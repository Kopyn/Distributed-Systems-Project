package com.example.productsvc.ri.inventory;

import com.example.productsvc.model.Status;

public interface InventoryServiceClient {
    boolean isProductAvailable(String uniqId);
}
