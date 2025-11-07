package com.adyan.payment.payment.gateway.configaration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodsRequest {
    private String merchantAccount;
    private String countryCode;
    private Amount amount;
    private String channel;
    private String shopperLocale;

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getShopperLocale() {
        return shopperLocale;
    }

    public void setShopperLocale(String shopperLocale) {
        this.shopperLocale = shopperLocale;
    }

    @Override
    public String toString() {
        return "PaymentMethodsRequest{" +
                "merchantAccount='" + merchantAccount + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", amount=" + amount +
                ", channel='" + channel + '\'' +
                ", shopperLocale='" + shopperLocale + '\'' +
                '}';
    }
}
