package com.example.sony.homeMain.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sony.homeMain.R;
import com.example.sony.homeMain.settings.SettingsActivity;
import com.example.sony.homeMain.userBean.UserDetails;

import com.example.sony.homeMain.dbConnection.LogTableHelper;

public class LoginActivity extends AppCompatActivity implements
        View.OnClickListener{

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }*/

    LogTableHelper userDetailsHelper;
    EditText etUserName,etPwd;
    Button btnLogin;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("LoginActivity", "Inside login activity oncreate: ");
        etUserName=(EditText) findViewById(R.id.etUserName);
        etPwd=(EditText)findViewById(R.id.reenterPin);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        super.onCreate(savedInstanceState);
        userDetailsHelper = new LogTableHelper(getApplicationContext(), "moneyTrackerCC.db", null, 1);
        //helper=new LogTableHelper(this);
        setContentView(R.layout.activity_login);
        //btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        btnLogin=(Button)findViewById(R.id.btnLogin);
        etUserName=(EditText) findViewById(R.id.etUserName);
        etPwd=(EditText)findViewById(R.id.reenterPin);
        btnLogin.setOnClickListener(this);
        switch (v.getId()){
            case R.id.btnLogin:
                //insert details here and verify details here
                UserDetails userDetails = new UserDetails();
                userDetails.setUname(etUserName.getText().toString());
                userDetails.setPwd(etPwd.getText().toString());
                userDetailsHelper.insertContact(userDetails);
                SharedPreferences.Editor editor = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
                editor.putString("userName", etUserName.getText().toString());
                editor.commit();
                Toast.makeText(getApplicationContext(), "User credentials successfully added ", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);

        }
    }
}
