package com.example.c0771910_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.c0771910_w2020_mad3125_fp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class addBillActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    private TextView billID;
    private TextView BillDate;
    private TextView unitsUsed;
    private TextView agencyName;
    private TextView minutesUsed;
    private TextView manufacturerName;
    private TextView planName;
    private Spinner spbillType;
    private TextView mobilenumber;
    private TextView dataused;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        billID = findViewById(R.id.BillIDTextInputEditText);
        BillDate = findViewById(R.id.BillDateTextInputEditText);
        unitsUsed = findViewById(R.id.enterunitsusedInputEditText);
         agencyName = findViewById(R.id.enteragencynameInputEditText);
         minutesUsed = findViewById(R.id.enterminutesusedInputEditText);
         manufacturerName = findViewById(R.id.entermanufacturernameInputEditText);
         planName = findViewById(R.id.enteryourplannameInputEditText);
        mobilenumber = findViewById(R.id.mobilenumberInputEditText);
        dataused = findViewById(R.id.datausedInputEditText);
        spbillType = findViewById(R.id.spinnertype);


        ArrayList<String> billType = new ArrayList<>();
        billType.add("MOBILE");
        billType.add("HYDRO");
        billType.add("INTERNET");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, billType);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spbillType.setAdapter(dataAdapter);

        spbillType.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);



    }



}
