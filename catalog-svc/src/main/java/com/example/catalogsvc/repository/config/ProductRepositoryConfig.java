package com.example.catalogsvc.repository.config;

import com.example.catalogsvc.repository.ProductRepository;
import com.example.catalogsvc.repository.impl.ProductRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductRepositoryConfig {
    @Bean
    public ProductRepository repository() {
        return new ProductRepositoryImpl();
    }
}
