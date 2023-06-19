package com.example.productsvc.ri.catalog;

import com.example.productsvc.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

public class CatalogServiceClientImpl implements CatalogServiceClient {
    private RestTemplate catalogClient = new RestTemplate();
    @Value("${svc.catalog.url}")
    private String CATALOG_URL;

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
        String encodedParam = UriComponentsBuilder.fromUriString(CATALOG_URL)
                .path("/GetProductsBySku")
                .queryParam("sku", sku)
                .encode()
                .toUriString();
        ResponseEntity<Product[]> response = catalogClient.exchange(
                encodedParam,
                HttpMethod.GET,
                null,
                Product[].class);
        if (response.getStatusCode().is2xxSuccessful()) {
            Product[] products = response.getBody();

            List<Product> productList = Arrays.asList(products);
            return productList;
        }
        return null;
    }
}
