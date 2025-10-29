package com.adyan.payment.payment.gateway.configaration.controller;

import com.adyan.payment.payment.gateway.configaration.entity.PaymentRequest;
import com.adyen.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.adyen.Client;
import com.adyen.enums.Environment;
import com.adyen.model.checkout.*;
import java.time.OffsetDateTime;
import java.util.*;
import com.adyen.model.RequestOptions;
import com.adyen.service.checkout.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Value("${adyen.merchant.account}")
    private String merchantAccount;

    @Autowired
    Client client;

    @PostMapping("/payment-methods")
    public Object createSession(@RequestBody PaymentRequest paymentRequest) throws Exception {
        // Create the request object(s)
        Amount amount = new Amount()
                .currency("INR")
                .value(1000L);

        CreateCheckoutSessionRequest createCheckoutSessionRequest = new CreateCheckoutSessionRequest()
                .reference("Order-12345")
                .amount(amount)
                .merchantAccount("TCSAccount984ECOM")
                .countryCode("IN")
                .returnUrl("https://your-company.example.com/checkout?shopperOrder=12xy");

        // Send the request
        PaymentsApi service = new PaymentsApi(client);
        CreateCheckoutSessionResponse response = service.sessions(createCheckoutSessionRequest, new RequestOptions().idempotencyKey("UUID"));
        return response;
    }
}
