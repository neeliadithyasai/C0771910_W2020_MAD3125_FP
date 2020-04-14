package com.example.c0771910_w2020_mad3125_fp.classes;

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


    }
}
