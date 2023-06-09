package com.example.inventorysvc.repository.config;

import com.example.inventorysvc.repository.AvailabilityRepository;
import com.example.inventorysvc.repository.impl.AvailabilityRepositoryImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AvailabilityRepositoryConfig {

    @Value("${repository.filepath}")
    private String fileName;

    @Bean
    public AvailabilityRepository repository() {
        return new AvailabilityRepositoryImpl(fileName);
    }

}
