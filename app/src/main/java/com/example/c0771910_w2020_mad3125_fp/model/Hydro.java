package com.example.c0771910_w2020_mad3125_fp.model;

public class Hydro extends Bill {

    private String agencyName;
    private int unitsConsumed;

    public Hydro(String billId, String billDate, String billType, Double billAmount,String agencyName,int unitsConsumed) {
        super(billId, billDate, billType, billAmount);
        this.agencyName = agencyName;
        this.unitsConsumed = unitsConsumed;
        this.billAmount = billCalculate();
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(int unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }



    public Double billCalculate(){
        double totalBillAmount = 0.0;
        if (unitsConsumed < 10)
        {
            totalBillAmount = 1.5 * unitsConsumed;
        }
        else
        {
            totalBillAmount = 2 * unitsConsumed;
        }
        return totalBillAmount;
    }
}
