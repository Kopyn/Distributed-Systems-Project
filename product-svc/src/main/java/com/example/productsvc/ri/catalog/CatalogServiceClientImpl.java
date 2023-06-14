package com.example.productsvc.ri.catalog;

import com.example.productsvc.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class CatalogServiceClientImpl implements CatalogServiceClient {
    private RestTemplate catalogClient = new RestTemplate();
    private final String CATALOG_URL = "http://localhost:8083/Product";
    @Override
    public Product getProductDataById(String uniqId) {
        String encodedParam = UriComponentsBuilder.fromUriString(CATALOG_URL)
                .path("/GetProductByUniqId")
                .queryParam("uniqId", uniqId)
                .encode()
                .toUriString();
        ResponseEntity<Product> response
                = catalogClient.getForEntity(encodedParam, Product.class);
        if(response.getStatusCode() == HttpStatus.OK){
            Product product = response.getBody();
            return product;
        }
        return null;
    }

    @Override
    public List<Product> getProductDataBySku(String sku) {
        return null;
    }
}
