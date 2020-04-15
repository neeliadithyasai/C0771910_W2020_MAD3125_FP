package com.example.c0771910_w2020_mad3125_fp.util;

import com.example.c0771910_w2020_mad3125_fp.model.Bill;
import com.example.c0771910_w2020_mad3125_fp.model.Customer;
import com.example.c0771910_w2020_mad3125_fp.model.Hydro;

import java.util.ArrayList;

public class DataManager
{
    private static DataManager INSTANCE = new DataManager();
    private ArrayList<Customer> customers = new ArrayList<>();

    private DataManager() {
        loaddata();
    }

    public void loaddata() {

        Hydro H1 = new Hydro("HYD001","28/07/1995","hydro",455.0,"rogers",25);

        Customer cust1 = new Customer("001","oliver","queen","oliverq@gmail.com");

        cust1.addBill("IN100", H1);

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


