package com.example.c0771910_w2020_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class loginActivity extends AppCompatActivity {

    private TextView username;
    private TextView password;
    private Switch rememberme;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.userName);
        password = findViewById(R.id.passWord);
        rememberme = findViewById(R.id.switchRememberMe);
        login = findViewById(R.id.btnLogin);


    }
}
