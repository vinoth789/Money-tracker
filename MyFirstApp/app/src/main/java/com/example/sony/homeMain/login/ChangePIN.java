package com.example.sony.homeMain.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sony.homeMain.R;
import com.example.sony.homeMain.dbConnection.LogTableHelper;
import com.example.sony.homeMain.settings.SettingsActivity;

public class ChangePIN extends AppCompatActivity implements View.OnClickListener {
    Button btnUpdatePin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pin);
        btnUpdatePin=(Button) findViewById(R.id.btnUpdatePin);
        btnUpdatePin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText enterPinValue = (EditText) findViewById(R.id.enterPin);
        EditText reenterPinValue = (EditText) findViewById(R.id.reenterPin);
        String fourDigitPinValue = enterPinValue.getText().toString();
        String reenterfourDigitPinValue = reenterPinValue.getText().toString();
        if(fourDigitPinValue.equals(reenterfourDigitPinValue)){
            SharedPreferences prefs = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
            String userName = prefs.getString("userName","");
            LogTableHelper dbHelper = new LogTableHelper(getApplicationContext(), "moneyTrackerCC.db", null, 1);
            Boolean pinEntry = dbHelper.updatePIN(userName,fourDigitPinValue);
           if(pinEntry){
               Toast.makeText(getApplicationContext(), "PIN updated successfully ", Toast.LENGTH_LONG).show();
               Intent intent = new Intent(this, SettingsActivity.class);
               startActivity(intent);
           }else{
               Toast.makeText(getApplicationContext(), "PIN updation failure ", Toast.LENGTH_LONG).show();
           }
        }else{
            Toast.makeText(getApplicationContext(), "PIN entered doesn't match with re-entered PIN ", Toast.LENGTH_LONG).show();
        }
    }
}
