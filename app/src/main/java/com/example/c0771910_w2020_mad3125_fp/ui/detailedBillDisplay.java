package com.example.c0771910_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.c0771910_w2020_mad3125_fp.R;
import com.example.c0771910_w2020_mad3125_fp.model.Bill;
import com.example.c0771910_w2020_mad3125_fp.model.Customer;
import com.example.c0771910_w2020_mad3125_fp.model.Hydro;
import com.example.c0771910_w2020_mad3125_fp.model.Mobile;

public class detailedBillDisplay extends AppCompatActivity {

    private TextView billtext;
    private ImageView billimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_bill_display);

        billtext = findViewById(R.id.txtbillDisplay);
        billimg = findViewById(R.id.imgBilldisplay);

        Intent mIntent = getIntent();
        Bill billObj = mIntent.getParcelableExtra("billOBJ");

        if(billObj.getBillType().matches("HYDRO"))
        {
            Intent hIntent = getIntent();
           Hydro hbillObj = hIntent.getParcelableExtra("billOBJ");

           billtext.setText(hbillObj.getBillId()+"\n"+hbillObj.getBillDate()+"\n"+hbillObj.getBillType()+"\n"+hbillObj.getAgencyName()+"\n"+hbillObj.getUnitsConsumed()+"\n"+hbillObj.getBillAmount());

        }if(billObj.getBillType().matches("MOBILE"))
        {
            Intent moIntent = getIntent();
            Mobile mbillObj = moIntent.getParcelableExtra("billOBJ");

            billtext.setText(mbillObj.getBillId()+"\n"+mbillObj.getBillDate()+"\n"+mbillObj.getBillType()+"\n"+mbillObj.g()+"\n"+hbillObj.getUnitsConsumed()+"\n"+hbillObj.getBillAmount());

        }else {

            billtext.setText("no bill found");
        }



    }
}
