package com.adyan.payment.payment.gateway.configaration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethods {
    private List<PaymentType> paymentMethods;

    public List<PaymentType> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentType> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
}
