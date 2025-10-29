package com.adyan.payment.payment.gateway.configaration.service;

import com.adyan.payment.payment.gateway.configaration.entity.PaymentEntity;
import com.adyan.payment.payment.gateway.configaration.entity.PaymentMethods;
import com.adyan.payment.payment.gateway.configaration.entity.PaymentMethodsRequest;
import com.adyan.payment.payment.gateway.configaration.entity.SessionRequest;
import com.adyen.model.checkout.PaymentLinkResponse;
import org.springframework.http.ResponseEntity;

public interface PaymentService {

    public Object createSession(SessionRequest entity);
    public PaymentMethods getPaymentMethods(PaymentMethodsRequest paymentMethodsRequest);
}
