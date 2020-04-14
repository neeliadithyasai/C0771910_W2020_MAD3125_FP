package com.example.c0771910_w2020_mad3125_fp.util;

import com.example.c0771910_w2020_mad3125_fp.model.Customer;

import java.util.ArrayList;

public class DataManager
{
    private static DataManager INSTANCE = new DataManager();
    private ArrayList<Customer> customers = new ArrayList<>();

    private DataManager() {

        addcts();
    }

    private void addcts() {

        Customer cust1 = new Customer("001","sherry","kaur","sherry@gmail.com");
        customers.add(cust1);
    }

    public static DataManager getInstance(){


        return INSTANCE;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }


    public ArrayList<Customer> getCustomers(){
        return customers;
    }






}


