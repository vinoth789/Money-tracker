package com.example.sony.homeMain.settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.sony.homeMain.R;
import com.example.sony.homeMain.login.ChangePIN;
import com.example.sony.homeMain.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String PREFS_NAME = "SwitchButton";
    SharedPreferences settings;
    Switch onOffSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Spinner spinner = (Spinner) findViewById(R.id.changeCurrencyspinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> currencyList = new ArrayList<String>();
        currencyList.add("Rupee");
        currencyList.add("Euro");
        currencyList.add("Dollar");
        currencyList.add("Kuno");
        currencyList.add("CHF");
        currencyList.add("Francs");


        ArrayAdapter<String> dataAdapter;

        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, currencyList);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        onOffSwitch = (Switch)  findViewById(R.id.enableDisableLogin);
       /* onOffSwitch = (Switch)  findViewById(R.id.enableDisableLogin);
        //onOffSwitch.setChecked(settings.getBoolean("pinEnabled",false));
        onOffSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //onOffSwitch.setChecked(settings.getBoolean("pinEnabled",false));
                if(isChecked) {
                    settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putBoolean("pinEnabled", true);
                    editor.commit();
                    //ParsePush.subscribeInBackground("egersund");
                    //Intent intent = new Intent(this, LoginActivity.class);
                    //startActivity(intent);
                }else{
                    settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putBoolean("pinEnabled", false);
                    editor.commit();
                }

            }
        });*/
        onOffSwitch.setOnClickListener(new View.OnClickListener() {

                                        @Override
                                        public void onClick(View v) {
                                            Boolean switchOnOff = onOffSwitch.isChecked();
                                            SharedPreferences.Editor editor = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
                                            editor.putBoolean("pinEnabled", switchOnOff);
                                            editor.commit();
                                            SharedPreferences prefs = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
                                            boolean clickedBefore = prefs.getBoolean("clickedBefore", false);
                                            if (switchOnOff)
                                            {
                                                if(!clickedBefore){
                                                    Intent intent = new Intent(v.getContext(),
                                                            LoginActivity.class);
                                                    startActivityForResult(intent, 0);
                                                    finish();
                                                    editor.putBoolean("clickedBefore", true);
                                                    editor.commit();
                                                }
                                            }
                                        }
                                    });

        SharedPreferences prefs = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        boolean switchState = prefs.getBoolean("pinEnabled", false);

        if (switchState == true)
        {
            onOffSwitch.setChecked(true);
        }
        else
        {
            onOffSwitch.setChecked(false);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void changePIN(View view) {
        Intent intent = new Intent(this, ChangePIN.class);
        startActivity(intent);
    }

    /*public void onSwitchClicked(View v){
        //Get reference of TextView from XML layout

        //Is the switch on?
        boolean on = ((Switch) v).isChecked();
        settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = settings.edit();
        SharedPreferences prefs = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        boolean firstClick = prefs.getBoolean("firstClick", false);
        if (on)
        {
            editor.putBoolean("pinEnabled", true);
            editor.commit();
            if(!firstClick){
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                editor.putBoolean("firstClick", true);
                editor.commit();
            }
        }
        else
        {
            editor.putBoolean("pinEnabled", false);
            editor.commit();
        }

    }*/


}
