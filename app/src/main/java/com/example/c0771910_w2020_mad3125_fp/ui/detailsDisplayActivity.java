package com.example.c0771910_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.c0771910_w2020_mad3125_fp.R;
import com.example.c0771910_w2020_mad3125_fp.model.Bill;
import com.example.c0771910_w2020_mad3125_fp.model.Customer;

import java.util.ArrayList;

public class detailsDisplayActivity extends AppCompatActivity {

    private TextView displaydata;
    private ArrayList billsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_display);

        displaydata = findViewById(R.id.dddisplay);

        Customer customer = (Customer) getIntent().getParcelableExtra("CustomerOBJ");
        billsArrayList = customer.getBills();

        displaydata.setText(customer.getEmailId() +"\n" + billsArrayList.size());



    }
}
