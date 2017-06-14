package com.example.sony.homeMain.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sony.homeMain.MainActivity;
import com.example.sony.homeMain.R;
import com.example.sony.homeMain.dbConnection.LogTableHelper;

public class LoginToHome extends AppCompatActivity implements View.OnClickListener {
    public static final String REDIRECT_TO_HOME = "com.example.myfirstapp.HOME";
    FloatingActionButton loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_to_home);
        loginBtn=(FloatingActionButton) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);
    }

   /* public void validatePIN(View view){
        EditText pinValue = (EditText) findViewById(R.id.pinValue);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        String fourDigitPin = pinValue.toString();
        SharedPreferences prefs = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        String userName = prefs.getString("userName","");
        SharedPreferences.Editor editor = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
        LogTableHelper dbHelper = new LogTableHelper(getApplicationContext(), "moneyTracker.db", null, 1);
        *//*loginBtn.setOnClickListener(this);
        switch (view.getId()){
            case R.id.loginBtn:*//*
        Cursor validatePin = dbHelper.validatePIN(userName);
        String mtPassword;
        Boolean isPinValid;
        mtPassword=validatePin.getString(0);
        if(mtPassword.equals(fourDigitPin)){
            isPinValid = true;
        }else{
            isPinValid = false;
        }
        if(isPinValid){
            Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class );
            editor.putString("redirectToHome","success");
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "Re enter PIN", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, LoginToHome.class);
            editor.putString("redirectToHome","failure");
            startActivity(intent);
        }


    }*/

    @Override
    public void onClick(View v) {
        EditText pinValue = (EditText) findViewById(R.id.pinValue);
        String fourDigitPin = pinValue.getText().toString();
        SharedPreferences prefs = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        String userName = prefs.getString("userName","");
        SharedPreferences.Editor editor = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
        LogTableHelper dbHelper = new LogTableHelper(getApplicationContext(), "moneyTrackerCC.db", null, 1);
        Cursor validatePin = dbHelper.validatePIN(userName);
        validatePin.moveToFirst();
        String mtPassword;
        Boolean isPinValid;
        mtPassword=validatePin.getString(0);
        if(mtPassword.equals(fourDigitPin)){
            isPinValid = true;
        }else{
            isPinValid = false;
        }
        if(isPinValid){
            Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class );
            editor.putString("redirectToHome","success");
            editor.commit();
            intent.putExtra(REDIRECT_TO_HOME, "success");
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "Re enter PIN", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, LoginToHome.class);
            editor.putString("redirectToHome","failure");
            editor.commit();
            intent.putExtra(REDIRECT_TO_HOME, "failure");
            startActivity(intent);
        }
    }




    /*@Override
    public void onClick(View view) {

        EditText pinValue = (EditText) findViewById(R.id.pinValue);
        String fourDigitPin = pinValue.toString();
        SharedPreferences prefs = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        String userName = prefs.getString("userName","");
        SharedPreferences.Editor editor = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
        LogTableHelper dbHelper = new LogTableHelper(getApplicationContext(), "moneyTracker.db", null, 1);
                Cursor validatePin = dbHelper.validatePIN(userName);
                String mtPassword;
                Boolean isPinValid;
                mtPassword=validatePin.getString(0);
                if(mtPassword.equals(fourDigitPin)){
                    isPinValid = true;
                }else{
                    isPinValid = false;
                }
                if(isPinValid){
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, MainActivity.class );
                    editor.putString("redirectToHome","success");
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Re enter PIN", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, LoginToHome.class);
                    editor.putString("redirectToHome","failure");
                    startActivity(intent);
                }


        }*/
    }
