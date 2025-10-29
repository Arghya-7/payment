package com.adyan.payment.payment.gateway.configaration.entity;

import com.adyen.model.checkout.Amount;

public class PaymentRequest {
    private Amount amount;

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }
}
