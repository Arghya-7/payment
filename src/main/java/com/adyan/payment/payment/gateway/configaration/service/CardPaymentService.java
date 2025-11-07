package com.adyan.payment.payment.gateway.configaration.service;

import com.adyan.payment.payment.gateway.configaration.entity.CardPaymentEntity;
import org.springframework.http.ResponseEntity;

public interface CardPaymentService {

    ResponseEntity<Object> cardPayment(CardPaymentEntity cardPaymentEntity);
}
