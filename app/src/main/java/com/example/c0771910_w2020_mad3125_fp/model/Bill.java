package com.example.c0771910_w2020_mad3125_fp.model;


import java.io.Serializable;

public abstract class Bill implements Idisplay, Serializable {


    private String billId;
    private String billDate;
    private String billType;
    private Double billAmount;

    public Bill(String billId, String billDate, String billType, Double billAmount) {
        this.billId = billId;
        this.billDate = billDate;
        this.billType = billType;
        this.billAmount = billAmount;
    }

    @Override
    public void print() {

    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }
}
