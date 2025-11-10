package com.adyan.payment.payment.gateway.configaration.controller;

import com.adyan.payment.payment.gateway.configaration.entity.CardPaymentEntity;
import com.adyan.payment.payment.gateway.configaration.entity.EncryptedCardPaymentEntity;
import com.adyan.payment.payment.gateway.configaration.service.CardPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/card-payment")
@RestController
public class CardPaymentController {

    CardPaymentService cardPaymentService;

    @Autowired
    CardPaymentController(CardPaymentService cardPaymentService){
        this.cardPaymentService = cardPaymentService;
    }

    @PostMapping("/unencrypted-pay")
    public ResponseEntity<Object> pay(@RequestBody CardPaymentEntity cardPaymentEntity){
        return cardPaymentService.cardPayment(cardPaymentEntity);
    }

    @PostMapping("/encrypted-payment")
    public ResponseEntity<Object> pay(@RequestBody EncryptedCardPaymentEntity encryptedCardPaymentEntity){
        return cardPaymentService.encryptedCardPayment(encryptedCardPaymentEntity);
    }
}
