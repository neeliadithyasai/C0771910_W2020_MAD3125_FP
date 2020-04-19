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
import com.example.c0771910_w2020_mad3125_fp.model.Internet;
import com.example.c0771910_w2020_mad3125_fp.model.Mobile;
import com.example.c0771910_w2020_mad3125_fp.util.StringExtension;

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
        Bill billObj = (Bill) mIntent.getSerializableExtra("billOBJ");

//        billtext.setText(billObj.getBillId().toUpperCase());

        if(billObj.getBillType().matches("HYDRO"))
        {

            billimg.setImageResource(R.mipmap.ic_hydro);

           Hydro hbillObj = (Hydro) mIntent.getSerializableExtra("billOBJ");

           billtext.setText("Bill ID    :   "+hbillObj.getBillId()+"\nBill Date    :   "+hbillObj.getBillDate()+"\nBill Type  :   "+hbillObj.getBillType()+"\nAgency Name    :   "+hbillObj.getAgencyName()+"\nUnits Consumed   :    "+hbillObj.getUnitsConsumed()+"\nBill Amount   :    "+StringExtension.doubleFormatter(hbillObj.getBillAmount()));

        }else if(billObj.getBillType().matches("MOBILE"))
        {
            billimg.setImageResource(R.mipmap.ic_mobile);

            Mobile mbillObj = (Mobile) mIntent.getSerializableExtra("billOBJ");

            billtext.setText("Bill ID    :   "+mbillObj.getBillId()+"\nBill Date    :   "+mbillObj.getBillDate()+"\nBill Type  :   "+mbillObj.getBillType()+"\nMobile No    :   "+mbillObj.getMobileNumber()+"\nModel Name  :   "+mbillObj.getModelName()+"\nPlan Name  :   "+mbillObj.getPlanName()+"\nInternet Used   :   "+mbillObj.getInternetUsed()+"\nMinutes used    :   "+mbillObj.getMinutesUsed()+"\nBill Amount  :   "+ StringExtension.doubleFormatter(mbillObj.getBillAmount()));

        }else if(billObj.getBillType().matches("INTERNET"))
        {
            billimg.setImageResource(R.mipmap.ic_internet);

            Internet ibillObj = (Internet) mIntent.getSerializableExtra("billOBJ");

            billtext.setText("Bill ID    :   "+ibillObj.getBillId()+"\nBill Date    :   "+ibillObj.getBillDate()+"\nBill Type  :   "+ibillObj.getBillType()+"\nInternet Provider  :   "+ibillObj.getProviderName()+"\nInternet Used  :  "+ibillObj.getInternetUsed()+"\nBill Amount  :   "+StringExtension.doubleFormatter(ibillObj.getBillAmount()));

        }else {

            billtext.setText("no bill found");
        }



    }
}
