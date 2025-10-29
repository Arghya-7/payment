package com.adyan.payment.payment.gateway.configaration.service.impl;

import com.adyan.payment.payment.gateway.configaration.entity.SessionRequest;
import com.adyan.payment.payment.gateway.configaration.helper.CustomPaymentHelper;
import com.adyan.payment.payment.gateway.configaration.service.PaymentService;
import com.adyan.payment.payment.gateway.configaration.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    RestTemplateService restTemplateService;
    CustomPaymentHelper customPaymentHelper;

    @Value("${adyen.checkout.url}")
    String url;

    @Value("${adyen.merchant.account}")
    String merchantAccount;

    @Autowired
    public PaymentServiceImpl(RestTemplateService restTemplateService, CustomPaymentHelper customPaymentHelper){
        this.restTemplateService = restTemplateService;
        this.customPaymentHelper = customPaymentHelper;
    }
    @Override
    public Object createSession(SessionRequest entity) {
        String orderId = customPaymentHelper.createOrderId();
        entity.setReference(orderId);
        entity.setMerchantAccount(merchantAccount);
        return restTemplateService.postForEntity(url + "/sessions", entity, customPaymentHelper.createHttpHeader(),Object.class);
    }
}
