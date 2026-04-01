package com.nisha.mockerp.model;

import jakarta.validation.constraints.NotBlank;

public class CustomerRequest {
    @NotBlank
    private String externalId;
    @NotBlank
    private String customerName;
    private String billingCity;
    private String billingCountry;
    private String salesforceId;
    private String status;

    public String getExternalId() { return externalId; }
    public void setExternalId(String externalId) { this.externalId = externalId; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getBillingCity() { return billingCity; }
    public void setBillingCity(String billingCity) { this.billingCity = billingCity; }
    public String getBillingCountry() { return billingCountry; }
    public void setBillingCountry(String billingCountry) { this.billingCountry = billingCountry; }
    public String getSalesforceId() { return salesforceId; }
    public void setSalesforceId(String salesforceId) { this.salesforceId = salesforceId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
