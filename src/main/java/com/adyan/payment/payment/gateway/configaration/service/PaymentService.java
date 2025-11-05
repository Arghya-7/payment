package com.adyan.payment.payment.gateway.configaration.service;

import com.adyan.payment.payment.gateway.configaration.entity.*;
import com.adyen.model.checkout.PaymentLinkResponse;
import org.springframework.http.ResponseEntity;

public interface PaymentService {

    public Object createSession(SessionRequest entity);
    public PaymentMethods getPaymentMethods(PaymentMethodsRequest paymentMethodsRequest);

    Object getPaymentDetails(PaymentResultRequest paymentResultRequest);
}
