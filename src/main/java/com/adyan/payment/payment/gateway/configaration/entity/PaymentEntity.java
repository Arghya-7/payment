package com.adyan.payment.payment.gateway.configaration.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class PaymentEntity {
    @Id
    private String id;
    private String currency;
    private long amount;
    private String email;
    private String countryCode;

    public PaymentEntity(String id, String currency, long amount, String email, String countryCode) {
        this.id = id;
        this.currency = currency;
        this.amount = amount;
        this.email = email;
        this.countryCode = countryCode;
    }

    public PaymentEntity() {
    }

    public String getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public long getAmount() {
        return amount;
    }

    public String getEmail() {
        return email;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "id='" + id + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", email='" + email + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
