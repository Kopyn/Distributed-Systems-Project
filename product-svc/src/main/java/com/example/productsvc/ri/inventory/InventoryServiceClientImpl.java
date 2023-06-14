package com.example.productsvc.ri.inventory;

import com.example.productsvc.model.Product;
import com.example.productsvc.model.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class InventoryServiceClientImpl implements InventoryServiceClient{

    private RestTemplate inventoryClient = new RestTemplate();
    private final String INVENTORY_URL = "http://localhost:8082";

    @Override
    public boolean isProductAvailable(String uniqId) {
        String encodedParam = UriComponentsBuilder.fromUriString(INVENTORY_URL)
                .path("/")
                .queryParam("uniqId", uniqId)
                .encode()
                .toUriString();
        ResponseEntity<Boolean> response
                = inventoryClient.getForEntity(encodedParam, boolean.class);
        if(response.getStatusCode() == HttpStatus.OK){
            Boolean availability = response.getBody();
            return availability;
        }
        return false;
    }
}
