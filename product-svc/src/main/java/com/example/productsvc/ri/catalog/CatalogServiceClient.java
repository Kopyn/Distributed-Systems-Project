package com.example.productsvc.ri.catalog;

import com.example.productsvc.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "catalog-svc", url = "http://localhost:8083/Product/")
public interface CatalogServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "GetProductByUniqId?uniqId={uniqId}")
    Product getProductDataById(@PathVariable("uniqId") String uniqId);
    @RequestMapping(method = RequestMethod.GET, value = "GetProductsBySku?sku={sku}")
    List<Product> getProductDataBySku(@PathVariable("sku") String sku);
}
