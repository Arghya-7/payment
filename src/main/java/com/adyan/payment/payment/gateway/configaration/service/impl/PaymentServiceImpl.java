package com.adyan.payment.payment.gateway.configaration.service.impl;

import com.adyan.payment.payment.gateway.configaration.entity.PaymentMethods;
import com.adyan.payment.payment.gateway.configaration.entity.PaymentMethodsRequest;
import com.adyan.payment.payment.gateway.configaration.entity.PaymentResultRequest;
import com.adyan.payment.payment.gateway.configaration.entity.SessionRequest;
import com.adyan.payment.payment.gateway.configaration.helper.CustomPaymentHelper;
import com.adyan.payment.payment.gateway.configaration.service.PaymentService;
import com.adyan.payment.payment.gateway.configaration.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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
        long amount = entity.getAmount().getValue()  * 100;
        entity.getAmount().setValue(amount);
        entity.setReference(orderId);
        entity.setMerchantAccount(merchantAccount);
        return restTemplateService.postForEntity(url + "/sessions", entity, customPaymentHelper.createHttpHeader(),Object.class);
    }

    @Override
    public PaymentMethods getPaymentMethods(PaymentMethodsRequest paymentMethodsRequest){
        paymentMethodsRequest.setMerchantAccount(merchantAccount);
        return  restTemplateService.postForEntity(url + "/paymentMethods",
                paymentMethodsRequest,customPaymentHelper.createHttpHeader(), PaymentMethods.class).getBody();
    }

    @Override
    public Object getPaymentDetails(PaymentResultRequest paymentResultRequest){
        String paymentResultUri = String.format(
                "/sessions/%s?sessionResult=%s",
                paymentResultRequest.getId(), URLEncoder.encode(paymentResultRequest.getSessionResult(), StandardCharsets.UTF_8)
        );
        return restTemplateService.getForEntity(url + paymentResultUri, customPaymentHelper.createHttpHeader(), Object.class);
    }

}
