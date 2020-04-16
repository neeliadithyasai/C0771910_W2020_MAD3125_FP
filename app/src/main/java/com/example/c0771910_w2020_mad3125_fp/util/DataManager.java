package com.example.c0771910_w2020_mad3125_fp.util;

import com.example.c0771910_w2020_mad3125_fp.model.Bill;
import com.example.c0771910_w2020_mad3125_fp.model.Customer;
import com.example.c0771910_w2020_mad3125_fp.model.Hydro;
import com.example.c0771910_w2020_mad3125_fp.model.Mobile;

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
        Mobile M1 = new Mobile("MOB001","28/07/1995","Mobile",500.5,"iphone", "0989789687","wakeup",15,24);

        Customer cust1 = new Customer("001","oliver","queen","oliverq@gmail.com");

        cust1.addBill("HYD", H1);
        cust1.addBill("MOB",M1);

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


