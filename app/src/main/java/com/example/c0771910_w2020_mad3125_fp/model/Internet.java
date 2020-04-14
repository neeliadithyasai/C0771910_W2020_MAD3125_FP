package com.example.c0771910_w2020_mad3125_fp.model;

public class Internet extends Bill {

    private String providerName;
    private Double internetUsed;


    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Double getInternetUsed() {
        return internetUsed;
    }

    public void setInternetUsed(Double internetUsed) {
        this.internetUsed = internetUsed;
    }

    public Internet(String billId, String billDate, String billType, Double billAmount, String providerName, Double internetUsed) {
        super(billId, billDate, billType, billAmount);
        this.providerName = providerName;
        this.internetUsed = internetUsed;
    }
}
