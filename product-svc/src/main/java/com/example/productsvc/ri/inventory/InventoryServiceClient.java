package com.example.productsvc.ri.inventory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "inventory-svc", url = "http://localhost:8082/")
public interface InventoryServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "?uniqId={uniqId}")
    boolean isProductAvailable(@PathVariable("uniqId") String uniqId);
}
