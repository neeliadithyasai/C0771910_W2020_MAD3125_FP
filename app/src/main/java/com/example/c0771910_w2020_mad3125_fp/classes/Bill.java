package com.example.c0771910_w2020_mad3125_fp.classes;


public abstract class Bill implements Idisplay {


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
}
