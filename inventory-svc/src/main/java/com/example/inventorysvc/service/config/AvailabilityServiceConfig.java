package com.example.inventorysvc.service.config;

import com.example.inventorysvc.service.AvailabilityService;
import com.example.inventorysvc.service.impl.AvailabilityServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AvailabilityServiceConfig {
    @Bean
    public AvailabilityService service() {
        return new AvailabilityServiceImpl();
    }
}
