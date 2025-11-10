package com.adyan.payment.payment.gateway.configaration.service;

import com.adyan.payment.payment.gateway.configaration.entity.CardPaymentEntity;
import com.adyan.payment.payment.gateway.configaration.entity.EncryptedCardPaymentEntity;
import org.springframework.http.ResponseEntity;

public interface CardPaymentService {

    ResponseEntity<Object> cardPayment(CardPaymentEntity cardPaymentEntity);

    ResponseEntity<Object> encryptedCardPayment(EncryptedCardPaymentEntity encryptedCardPaymentEntity);
}
