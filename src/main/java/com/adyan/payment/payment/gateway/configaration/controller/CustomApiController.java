package com.adyan.payment.payment.gateway.configaration.controller;

import com.adyan.payment.payment.gateway.configaration.entity.PaymentMethods;
import com.adyan.payment.payment.gateway.configaration.entity.PaymentMethodsRequest;
import com.adyan.payment.payment.gateway.configaration.entity.PaymentResultRequest;
import com.adyan.payment.payment.gateway.configaration.entity.SessionRequest;
import com.adyan.payment.payment.gateway.configaration.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/adyan-payment/")
public class CustomApiController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/session")
    public Object createSession(@RequestBody SessionRequest sessionRequest){
        return paymentService.createSession(sessionRequest);
    }

    @PostMapping("/payment-types")
    public PaymentMethods getPaymentMethods(@RequestBody PaymentMethodsRequest paymentMethodsRequest){
        return paymentService.getPaymentMethods(paymentMethodsRequest);
    }

    @PostMapping("/get-payment-details")
    public Object getPaymentDetails(@RequestBody PaymentResultRequest paymentResultRequest){
        return paymentService.getPaymentDetails(paymentResultRequest);
    }
}
