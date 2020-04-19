package com.example.c0771910_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.c0771910_w2020_mad3125_fp.R;
import com.example.c0771910_w2020_mad3125_fp.adapters.billsAdapter;
import com.example.c0771910_w2020_mad3125_fp.model.Bill;
import com.example.c0771910_w2020_mad3125_fp.model.Customer;
import com.example.c0771910_w2020_mad3125_fp.util.DataManager;

import java.util.ArrayList;

public class detailsDisplayActivity extends AppCompatActivity {

    private RecyclerView rvBillsList;
    private ArrayList billsArrayList;
    private billsAdapter BillsAdapter;
    private TextView CustId;
    private TextView custName;
    private TextView custEmailId;
    private TextView custTotal;

    public static int name = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_display);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setTitle("YOUR BILLS");

        rvBillsList = findViewById(R.id.rvBillsList);
        CustId = findViewById(R.id.txtCustomerId);
        custName = findViewById(R.id.txtCustomerName);
        custEmailId = findViewById(R.id.txtCustomerEmail);
        custTotal = findViewById(R.id.txtCustomerTotalAmount);



//        custTotal.setText(String.valueOf(customerObj.getTotalAmount()));

        fillData();




    }
    @Override
    protected void onRestart() {
        super.onRestart();
        fillData();

    }



    private void fillData() {

            Intent mIntent = getIntent();
            Customer customerObj = mIntent.getParcelableExtra("CustomerOBJ");

         billsArrayList = customerObj.getBills();

//       billsArrayList = DataManager.getInstance().getcstbills(customerObj);


            BillsAdapter = new billsAdapter(billsArrayList);


            RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

            rvBillsList.setLayoutManager(mLinearLayoutManager);
            rvBillsList.setAdapter(BillsAdapter);

            CustId.setText(customerObj.getFullName());
            custName.setText(customerObj.getFirstName());
            custEmailId.setText(customerObj.getEmailId());
            custTotal.setText(String.valueOf(customerObj.getTotalAmount()));



    }



    public ArrayList<Bill> getBillsArrayList()
    {
        return this.billsArrayList;
    }


    public boolean onCreateOptionsMenu(Menu menu) {         //https://javatpoint.com/android-option-menu-example

        getMenuInflater().inflate(R.menu.addbill, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu3:
                Intent mIntent = getIntent();
                Customer customerObj = mIntent.getParcelableExtra("CustomerOBJ");
                Intent intent3 = new Intent(detailsDisplayActivity.this, addBillActivity.class);
                intent3.putExtra("CustomerOBJ",customerObj);
                startActivity(intent3);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
