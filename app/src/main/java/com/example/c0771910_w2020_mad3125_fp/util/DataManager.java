package com.example.c0771910_w2020_mad3125_fp.util;

import com.example.c0771910_w2020_mad3125_fp.model.Bill;
import com.example.c0771910_w2020_mad3125_fp.model.Customer;
import com.example.c0771910_w2020_mad3125_fp.model.Hydro;
import com.example.c0771910_w2020_mad3125_fp.model.Internet;
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

        Hydro H1 = new Hydro("HYD001","28/07/2019","HYDRO",455.0,"Rogers",25);
        Mobile M1 = new Mobile("MOB001","28/07/2018","MOBILE",500.5,"iphone", "0989789687","wakeup",15,24);
        Internet I1 = new Internet("INT001","25/01/2019","INTERNET",75.0,"Rogers",15.0);


        Hydro H2 = new Hydro("HYD002","2/05/2019","HYDRO",156.0,"Fido",25);
        Mobile M2 = new Mobile("MOB002","28/07/2020","MOBILE",50.5,"Samsung s10", "4675897864","ultra data",15,24);
        Internet I2 = new Internet("INT002","25/01/2019","INTERNET",75.0,"Rogers",15.0);

        Mobile M3 = new Mobile("MOB003","21/08/2020","MOBILE",150.5,"Blackberry Q10", "9097858678","ultra saver",15,50);
        Internet I3 = new Internet("INT003","25/01/2019","INTERNET",175.0,"Freedom",15.0);

        Customer cust1 = new Customer("C001","oliver","queen","oliverq@gmail.com");
        Customer cust2 = new Customer("C002","Barry","Allen","barryallen@gmail.com");
        Customer cust3 = new Customer("C003","Tommy","shelby","shelby.t@gmail.com");

        cust1.addBill(H1.getBillId(), H1);
        cust1.addBill(M1.getBillId(),M1);
        cust1.addBill(I1.getBillId(),I1);

        cust2.addBill(H2.getBillId(), H2);
        cust2.addBill(M2.getBillId(),M2);
        cust2.addBill(I2.getBillId(),I2);

        cust3.addBill(M3.getBillId(),M3);
        cust3.addBill(I3.getBillId(),I3);


        customers.add(cust1);
        customers.add(cust2);
        customers.add(cust3);

    }

    public static DataManager getInstance(){
        return INSTANCE;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void addBill(Customer customer,Bill bill)
    {
        customer.addBill(bill.getBillId(),bill);
    }

    public ArrayList<Bill> getcstbills(Customer customer)
    {
        return customer.getBills();
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }






}


