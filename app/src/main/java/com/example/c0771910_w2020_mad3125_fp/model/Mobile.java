package com.example.c0771910_w2020_mad3125_fp.model;

public class Mobile extends Bill{
    private String modelName;
    private String mobileNumber;
    private String planName;
    private int internetUsed;
    private int minutesUsed;

    public Mobile(String billId, String billDate, String billType, Double billAmount,String modelName,String mobileNumber,String planName,int internetUsed,int minutesUsed) {
        super(billId, billDate, billType, billAmount);

        this.modelName = modelName;
        this.mobileNumber = mobileNumber;
        this.planName = planName;
        this.internetUsed = internetUsed;
        this.minutesUsed = minutesUsed;
        this.billAmount = billCalculate();


    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public int getInternetUsed() {
        return internetUsed;
    }

    public void setInternetUsed(int internetUsed) {
        this.internetUsed = internetUsed;
    }

    public int getMinutesUsed() {
        return minutesUsed;
    }

    public void setMinutesUsed(int minutesUsed) {
        this.minutesUsed = minutesUsed;
    }
    public Double billCalculate(){
        double totalBillAmount = 0.0;
        totalBillAmount = (this.internetUsed ) * 25 + (this.minutesUsed) * 0.2;
        return totalBillAmount;
    }
}
