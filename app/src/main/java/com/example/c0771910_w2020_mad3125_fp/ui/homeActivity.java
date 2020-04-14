package com.example.c0771910_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.c0771910_w2020_mad3125_fp.R;
import com.example.c0771910_w2020_mad3125_fp.adapters.customerAdapter;
import com.example.c0771910_w2020_mad3125_fp.classes.Customer;
import com.example.c0771910_w2020_mad3125_fp.classes.UserPrefs;

import java.util.ArrayList;

public class homeActivity extends AppCompatActivity {


    private RecyclerView rVCustomersList;
    private ArrayList<Customer> customersLIST = new ArrayList<>();
    private com.example.c0771910_w2020_mad3125_fp.adapters.customerAdapter customerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rVCustomersList = findViewById(R.id.rvCustomerList);

        populateCustomers();


        customerAdapter = new customerAdapter(customersLIST,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rVCustomersList.setLayoutManager(mLayoutManager);
        rVCustomersList.setAdapter(customerAdapter);


    }

    private void populateCustomers() {

        // get a SharedPreferences instance
        UserPrefs prefs = new UserPrefs( this.getApplicationContext() );

        // get id from server or local storage
        // then find User with that id
        String Id ="";
        Customer customer1 = prefs.getUser(Id);
         Customer customer2= prefs.getUser(Id);

        // operations on User, e.g.
        customer1.setCustomerId("c001");
        customer1.setFirstName("Adithyasai");
        customer1.setLastName("Neeli");
        customer1.setEmailId("neeliadithyasai@gmail.com");
        customer2.setCustomerId("c002");
        customer2.setFirstName("nikhil");
        customer2.setLastName("Kulkarni");
        customer2.setEmailId("kulkarninikhil@gmail.com");


        // save
        prefs.setUser(customer1);
        // ...or delete
        //prefs.deleteUser(customer);



        customersLIST.add(new Customer("c001","trial","trial2","trial@gmail.com"));
        customersLIST.add(new Customer("c002","Adithya","sai","as@gmail.com"));
        customersLIST.add(customer1);
        customersLIST.add(customer2);

    }
}
