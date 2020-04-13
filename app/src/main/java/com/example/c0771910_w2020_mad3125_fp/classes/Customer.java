package com.example.c0771910_w2020_mad3125_fp.classes;

import java.util.Dictionary;

public class Customer implements Idisplay{

    private String customerId;
    private String firstName;
    private String lastName;
    private String emailId;
    private Dictionary<String,Bill> customerBills;

    public Customer(String customerId, String firstName, String lastName, String emailId) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    @Override
    public void print() {

    }
}
