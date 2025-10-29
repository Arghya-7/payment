package com.adyan.payment.payment.gateway.configaration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CommonConfig {

    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}
