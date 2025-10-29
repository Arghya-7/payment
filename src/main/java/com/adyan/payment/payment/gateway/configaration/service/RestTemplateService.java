package com.adyan.payment.payment.gateway.configaration.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public interface RestTemplateService {
    <T> ResponseEntity<T> getForEntity(String url, HttpHeaders headers, Class<T> responseType);

    <T, R> ResponseEntity<R> postForEntity(String url, T body, HttpHeaders headers, Class<R> responseType);
}
