package com.example.c0771910_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.c0771910_w2020_mad3125_fp.R;
import com.example.c0771910_w2020_mad3125_fp.adapters.customerAdapter;
import com.example.c0771910_w2020_mad3125_fp.model.Customer;

import java.util.ArrayList;

public class homeActivity extends AppCompatActivity {


    private RecyclerView rVCustomersList;
    private com.example.c0771910_w2020_mad3125_fp.adapters.customerAdapter customerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rVCustomersList = findViewById(R.id.rvCustomerList);
        customerAdapter = new customerAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rVCustomersList.setLayoutManager(mLayoutManager);
        rVCustomersList.setAdapter(customerAdapter);


    }
    @Override
    protected void onRestart() {
        super.onRestart();

    }


}
