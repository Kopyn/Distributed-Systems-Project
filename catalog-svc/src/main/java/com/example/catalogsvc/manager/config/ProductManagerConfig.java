package com.example.catalogsvc.manager.config;

import com.example.catalogsvc.manager.ProductManager;
import com.example.catalogsvc.manager.impl.ProductManagerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductManagerConfig {
    @Bean
    public ProductManager manager() {
        return new ProductManagerImpl();
    }
}
