package com.example.c0771910_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.c0771910_w2020_mad3125_fp.R;
import com.example.c0771910_w2020_mad3125_fp.model.Customer;
import com.example.c0771910_w2020_mad3125_fp.util.DataManager;
import com.example.c0771910_w2020_mad3125_fp.util.StringExtension;

public class addCustomerActivity extends AppCompatActivity {
    private TextView customerId;
    private TextView customerFirstName;
    private TextView customerLastName;
    private TextView customerEmailId;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        customerId = findViewById(R.id.customerIDTextInputEditText);
        customerFirstName = findViewById(R.id.firstNameTextInputEditText);
        customerLastName = findViewById(R.id.lastNameTextInputEditText);
        customerEmailId = findViewById(R.id.customerEmailTextInputEditText);
        save = findViewById(R.id.customerbutton);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (customerId.getText().toString().matches("")){
                    customerId.setError("enter customer ID!");
                }else if(customerFirstName.getText().toString().matches("")){
                    customerFirstName.setError("enter FirstName!");
                }else if(customerLastName.getText().toString().matches("")){
                    customerLastName.setError("enter Last Name!");
                }else if(customerEmailId.getText().toString().matches("")){
                    customerEmailId.setError("enter Email!");
                }else if(StringExtension.emailValidation(customerEmailId.getText().toString()) == true)
                {
                    Customer tempObj = new Customer(customerId.getText().toString(),customerFirstName.getText().toString(),customerLastName.getText().toString(),customerEmailId.getText().toString());
                    DataManager.getInstance().addCustomer(tempObj);
                    finish();
                }else  {
                    customerEmailId.setError("enter Valid email!");
                }



            }
        });




    }
}
