package com.adyan.payment.payment.gateway.configaration.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomPaymentHelper {
    @Value("${adyen.api.key}")
    String apiKey;


    public String createOrderId(){
        String orderId = UUID.randomUUID().toString().replace("-","");
        return "Order-" + orderId;
    }

    public HttpHeaders createHttpHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        httpHeaders.set("x-api-key", apiKey);
        return httpHeaders;
    }
}
