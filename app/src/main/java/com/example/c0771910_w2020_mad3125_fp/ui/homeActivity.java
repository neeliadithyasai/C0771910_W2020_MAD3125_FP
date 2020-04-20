package com.example.c0771910_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setTitle("Customers");

        fillData();



    }
    @Override
    protected void onRestart() {
        super.onRestart();
        fillData();

    }

    private void fillData() {
        rVCustomersList = findViewById(R.id.rvCustomerList);
        customerAdapter = new customerAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rVCustomersList.setLayoutManager(mLayoutManager);
        rVCustomersList.setAdapter(customerAdapter);


    }

    public boolean onCreateOptionsMenu(Menu menu) {         //https://javatpoint.com/android-option-menu-example

        getMenuInflater().inflate(R.menu.addcustomer, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                Intent intent2 = new Intent(homeActivity.this, addCustomerActivity.class);
                startActivity(intent2);

                return true;
            case R.id.menu2:

                new AlertDialog.Builder(homeActivity.this)
                        .setTitle("logout!!")
                        .setMessage("Are you sure want to logout?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
