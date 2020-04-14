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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Dictionary<String, Bill> getCustomerBills() {
        return customerBills;
    }

    public void setCustomerBills(Dictionary<String, Bill> customerBills) {
        this.customerBills = customerBills;
    }
}
