package com.example.catalogsvc.repository.config;

import com.example.catalogsvc.repository.ProductRepository;
import com.example.catalogsvc.repository.impl.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductRepositoryConfig {

    @Value("${repository.filepath}")
    private String fileName;

    @Bean
    public ProductRepository repository() {
        return new ProductRepositoryImpl(fileName);
    }
}
