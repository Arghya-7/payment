package com.adyan.payment.payment.gateway.configaration.service;

import com.adyan.payment.payment.gateway.configaration.entity.PaymentEntity;
import com.adyan.payment.payment.gateway.configaration.entity.SessionRequest;
import com.adyen.model.checkout.PaymentLinkResponse;
import org.springframework.http.ResponseEntity;

public interface PaymentService {

    Object createSession(SessionRequest entity);
}
