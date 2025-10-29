package com.adyan.payment.payment.gateway.configaration.service.impl;

import com.adyan.payment.payment.gateway.configaration.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    RestTemplate restTemplate;
    @Autowired
    public  RestTemplateServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public <T> ResponseEntity<T> getForEntity(String url, HttpHeaders headers, Class<T> responseType) {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, responseType);
    }

    @Override
    public <T, R> ResponseEntity<R> postForEntity(String url, T body, HttpHeaders headers, Class<R> responseType) {
        HttpEntity<T> entity = new HttpEntity<>(body, headers);
        return restTemplate.exchange(url, HttpMethod.POST, entity, responseType);
    }
}
