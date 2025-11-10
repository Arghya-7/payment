package com.adyan.payment.payment.gateway.configaration.service.impl;

import com.adyan.payment.payment.gateway.configaration.entity.CardPaymentEntity;
import com.adyan.payment.payment.gateway.configaration.entity.EncryptedCardPaymentEntity;
import com.adyan.payment.payment.gateway.configaration.helper.CustomPaymentHelper;
import com.adyan.payment.payment.gateway.configaration.service.CardPaymentService;
import com.adyan.payment.payment.gateway.configaration.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CardPaymentServiceImpl implements CardPaymentService {

    @Value("${adyan.card.uri}")
    String uri;

    @Value("${adyen.checkout.url}")
    String checkoutUri;
    RestTemplateService restTemplateService;
    CustomPaymentHelper customPaymentHelper;


    @Autowired
    public CardPaymentServiceImpl(RestTemplateService restTemplateService, CustomPaymentHelper customPaymentHelper){
        this.restTemplateService = restTemplateService;
        this.customPaymentHelper = customPaymentHelper;
    }

    @Override
    public ResponseEntity<Object> cardPayment(CardPaymentEntity cardPaymentEntity){
        return restTemplateService.postForEntity(uri, cardPaymentEntity, customPaymentHelper.createHttpHeader(), Object.class);
    }

    @Override
    public ResponseEntity<Object> encryptedCardPayment(EncryptedCardPaymentEntity encryptedCardPaymentEntity) {
        return restTemplateService.postForEntity(checkoutUri + "/payments", encryptedCardPaymentEntity,
                customPaymentHelper.createHttpHeader(), Object.class);
    }
}
