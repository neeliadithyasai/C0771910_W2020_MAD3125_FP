package com.example.c0771910_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.c0771910_w2020_mad3125_fp.R;
import com.example.c0771910_w2020_mad3125_fp.classes.Customer;
import com.example.c0771910_w2020_mad3125_fp.classes.UserPrefs;

public class homeActivity extends AppCompatActivity {

    private TextView txtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtd =findViewById(R.id.txtdisplay);

        // get a SharedPreferences instance
        UserPrefs prefs = new UserPrefs( this.getApplicationContext() );

        // get id from server or local storage
        // then find User with that id
        String Id ="";
        Customer customer = prefs.getUser(Id);
       // Customer customer1= prefs.getUser(Id);

        // operations on User, e.g.
        customer.setCustomerId("c001");
        customer.setFirstName("Adithyasai");
        customer.setLastName("Neeli");
        customer.setEmailId("neeliadithyasai@gmail.com");


        // save
        prefs.setUser(customer);
        // ...or delete
        //prefs.deleteUser(customer);


        txtd.setText(customer.getFirstName());
    }
}
