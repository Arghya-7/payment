package com.adyan.payment.payment.gateway.configaration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResultRequest {
    private String id;
    private String sessionResult;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSessionResult() {
        return sessionResult;
    }

    public void setSessionResult(String sessionResult) {
        this.sessionResult = sessionResult;
    }

    @Override
    public String toString() {
        return "PaymentResultRequest{" +
                "id='" + id + '\'' +
                ", sessionResult='" + sessionResult + '\'' +
                '}';
    }
}
