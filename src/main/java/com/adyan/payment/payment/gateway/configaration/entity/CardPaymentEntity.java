package com.adyan.payment.payment.gateway.configaration.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardPaymentEntity {
    private String reference;
    private Amount amount;
    private String merchantAccount;
    private Card card;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
