package com.example.productsvc.circuit_breaker;

import feign.FeignException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.HttpServerErrorException;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Configuration
public class CircuitBreakerConfiguration {

    @Bean
    public io.github.resilience4j.circuitbreaker.CircuitBreakerConfig circuitBreakerConfig() {
        return io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.custom()
                .failureRateThreshold(30)
                .minimumNumberOfCalls(10)
                .slidingWindowType(io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType.TIME_BASED)
                .slidingWindowSize(100)
                .recordExceptions(IOException.class, TimeoutException.class, HttpServerErrorException.class, FeignException.ServiceUnavailable.class)
                .build();
    }

}
