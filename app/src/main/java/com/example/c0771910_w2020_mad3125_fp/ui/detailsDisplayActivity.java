package com.example.c0771910_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.c0771910_w2020_mad3125_fp.R;
import com.example.c0771910_w2020_mad3125_fp.adapters.billsAdapter;
import com.example.c0771910_w2020_mad3125_fp.model.Bill;
import com.example.c0771910_w2020_mad3125_fp.model.Customer;

import java.util.ArrayList;

public class detailsDisplayActivity extends AppCompatActivity {

    private RecyclerView rvBillsList;
    private ArrayList billsArrayList;
    private billsAdapter BillsAdapter;
    private TextView CustId;
    private TextView custName;
    private TextView custEmailId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_display);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setTitle("YOUR BILLS");

        Intent mIntent = getIntent();
        Customer customerObj = mIntent.getParcelableExtra("CustomerOBJ");
        billsArrayList = customerObj.getBills();

        rvBillsList = findViewById(R.id.rvBillsList);
        CustId = findViewById(R.id.txtCustomerId);
        custName = findViewById(R.id.txtCustomerName);
        custEmailId = findViewById(R.id.txtCustomerEmail);

        CustId.setText(customerObj.getFullName());
        custName.setText(customerObj.getFirstName());
        custEmailId.setText(customerObj.getEmailId());
        BillsAdapter = new billsAdapter(this.billsArrayList);


        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvBillsList.setLayoutManager(mLinearLayoutManager);
        rvBillsList.setAdapter(BillsAdapter);



    }
    public ArrayList<Bill> getBillsArrayList()
    {
        return this.billsArrayList;
    }
}
