package com.adyan.payment.payment.gateway.configaration.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Amount {
    private String currency;
    private long value;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "currency='" + currency + '\'' +
                ", value=" + value +
                '}';
    }
}
