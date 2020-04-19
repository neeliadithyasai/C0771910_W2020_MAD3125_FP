package com.example.c0771910_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c0771910_w2020_mad3125_fp.R;

public class loginActivity extends AppCompatActivity {

    private TextView username;
    private TextView password;
    private Switch rememberme;
    private Button login;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setTitle("Login Screen");


        iniit();


        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                login();
            }
        });





    }

    private void iniit(){

        username = findViewById(R.id.userName);
        password = findViewById(R.id.passWord);
        rememberme = findViewById(R.id.switchRememberMe);
        login = findViewById(R.id.btnLogin);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        saveLogin = loginPreferences.getBoolean("saveLogin", false);


        if(saveLogin == true)
        {
            username.setText(loginPreferences.getString("username", ""));
            password.setText(loginPreferences.getString("password", ""));
            rememberme.setChecked(true);
            Toast.makeText(loginActivity.this,"ON",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(loginActivity.this,"OFF",Toast.LENGTH_LONG).show();
        }




    }


    private void login() {
        String userName = username.getText().toString();
        final String passWord = password.getText().toString();

        if (userName.isEmpty() || userName.trim().length() == 0) {
            username.setError("Enter Email ID");
            return;
        }
        if(userName.equals("admin@gmail.com") && passWord.equals("admin@123")) {

            if (rememberme.isChecked()) {
                loginPrefsEditor.putBoolean("saveLogin", true);
                loginPrefsEditor.putString("username", userName);
                loginPrefsEditor.putString("password", passWord);
                loginPrefsEditor.commit();

            } else {
                username.setText("");
                password.setText("");
                loginPrefsEditor.clear();
                loginPrefsEditor.commit();
            }

            Intent mIntent = new Intent(loginActivity.this, homeActivity.class);
            startActivity(mIntent);


        }else{
            new AlertDialog.Builder(loginActivity.this)
                    .setTitle("Inalid Credentials!")
                    .setMessage("enter valid username and password")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                           username.setText("");
                           password.setText("");
                        }
                    })

                    // A null listener allows the button to dismiss the dialog and take no further action.
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }
}
