package com.adyan.payment.payment.gateway.configaration.entity;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SessionRequest {
    private String reference;
    private Amount amount;
    private String countryCode;
    private String merchantAccount;
    private String shopperReference;
    private String shopperEmail;
    private String returnUrl;
    private List<String> allowedPaymentMethods;
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public String getShopperEmail() {
        return shopperEmail;
    }

    public void setShopperEmail(String shopperEmail) {
        this.shopperEmail = shopperEmail;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public List<String> getAllowedPaymentMethods() {
        return allowedPaymentMethods;
    }

    public void setAllowedPaymentMethods(List<String> allowedPaymentMethods) {
        this.allowedPaymentMethods = allowedPaymentMethods;
    }

    @Override
    public String toString() {
        return "SessionRequest{" +
                "reference='" + reference + '\'' +
                ", amount=" + amount +
                ", countryCode='" + countryCode + '\'' +
                ", merchantAccount='" + merchantAccount + '\'' +
                ", shopperReference='" + shopperReference + '\'' +
                ", shopperEmail='" + shopperEmail + '\'' +
                ", returnUrl='" + returnUrl + '\'' +
                ", allowedPaymentMethods=" + allowedPaymentMethods +
                '}';
    }
}
