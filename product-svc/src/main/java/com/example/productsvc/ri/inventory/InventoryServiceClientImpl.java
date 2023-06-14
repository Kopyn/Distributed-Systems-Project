package com.example.productsvc.ri.inventory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class InventoryServiceClientImpl implements InventoryServiceClient{

    private final RestTemplate inventoryClient = new RestTemplate();
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
            if (response.hasBody())
                return response.getBody();
        }
        return false;
    }
}
