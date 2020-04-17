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
import com.example.c0771910_w2020_mad3125_fp.model.Customer;
import com.example.c0771910_w2020_mad3125_fp.model.Hydro;
import com.example.c0771910_w2020_mad3125_fp.model.Mobile;
import com.example.c0771910_w2020_mad3125_fp.util.DataManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;


public class addBillActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    private TextView billID;
    private TextView billDate;
    private TextView unitsUsed;
    private TextView agencyName;
    private TextView minutesUsed;
    private TextView manufacturerName;
    private TextView planName;
    private Spinner spbillType;
    private TextView mobilenumber;
    private TextView dataused;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);

        fab = findViewById(R.id.fab);
        billID = findViewById(R.id.BillIDTextInputEditText);
        billDate = findViewById(R.id.BillDateTextInputEditText);
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


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
        ((TextView) parent.getChildAt(0)).setTextSize(18);
        ((TextView) parent.getChildAt(0)).setTypeface(null, Typeface.BOLD);

        if(position == 0)
        {
            initFields();
            clearfields();
            unitsUsed.setVisibility(View.INVISIBLE);
            agencyName.setVisibility(View.INVISIBLE);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        if(position == 1)
        {
            hidefields();
            clearfields();
            unitsUsed.setVisibility(View.VISIBLE);
            agencyName.setVisibility(View.VISIBLE);
            agencyName.setHint("ENTER AGENCY NAME");
//            unitsUsed.setHint("ENTER UNITS USED");
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent hIntent = getIntent();
                    Customer customerObj = hIntent.getParcelableExtra("CustomerOBJ");


                    Hydro tempHydro = new Hydro(billID.getText().toString(),billDate.getText().toString(),"hydro",50.5,agencyName.getText().toString(),Integer.parseInt(unitsUsed.getText().toString()));

                    //customerObj.addBill(tempHydro.getBillId(),tempHydro);
                   DataManager.getInstance().addBill(customerObj,tempHydro);
//
//                    Intent intent3 = new Intent();
//                    intent3.putExtra("CustomerOBJ",customerObj);
//                    setResult(RESULT_OK,intent3);

                    finish();





                }
            });
        }

        if(position == 2)
        {
           hidefields();
            clearfields();
            dataused.setVisibility(View.VISIBLE);
            agencyName.setVisibility(View.VISIBLE);
            agencyName.setHint("ENTER PROVIDER NAME");
//            unitsUsed.setHint("ENTER DATA USED");
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void initFields()
    {
        minutesUsed.setVisibility(View.VISIBLE);
        mobilenumber.setVisibility(View.VISIBLE);
        dataused.setVisibility(View.VISIBLE);
      minutesUsed.setVisibility(View.VISIBLE);
        planName.setVisibility(View.VISIBLE);
        manufacturerName.setVisibility(View.VISIBLE);
    }
    public void hidefields()
    {
        minutesUsed.setVisibility(View.INVISIBLE);
        mobilenumber.setVisibility(View.INVISIBLE);
        dataused.setVisibility(View.INVISIBLE);
       minutesUsed.setVisibility(View.INVISIBLE);
        planName.setVisibility(View.INVISIBLE);
        manufacturerName.setVisibility(View.INVISIBLE);
    }

    public void clearfields()
    {
        mobilenumber.setText("");
        dataused.setText("");
        minutesUsed.setText("");
        planName.setText("");
        manufacturerName.setText("");
        billDate.setText("");
        billID.setText("");
        agencyName.setText("");
        dataused.setText("");
        unitsUsed.setText("");
    }
}
