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
    String selectedCurrency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Spinner spinner = (Spinner) findViewById(R.id.changeCurrencyspinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> currencyList = new ArrayList<String>();
        currencyList.add("EUR");currencyList.add("AOA");currencyList.add("ARS");currencyList.add("AUD");
        currencyList.add("AED");currencyList.add("AWG");currencyList.add("AZN");currencyList.add("BAM");
        currencyList.add("AFN");currencyList.add("BAM");currencyList.add("BDT");currencyList.add("BGN");
        currencyList.add("ALL");currencyList.add("BHD");currencyList.add("BIF");currencyList.add("BMD");
        currencyList.add("AMD");currencyList.add("BND");currencyList.add("BOB");currencyList.add("BRL");
        currencyList.add("ANG");currencyList.add("BSD");currencyList.add("BTN");currencyList.add("BWP");
        currencyList.add("BYN");currencyList.add("BZD");currencyList.add("CAD");currencyList.add("CDF");
        currencyList.add("ANG");currencyList.add("BSD");currencyList.add("BTN");currencyList.add("BWP");
        currencyList.add("CHF");currencyList.add("CLP");currencyList.add("CNY");currencyList.add("COP");
        currencyList.add("CRC");currencyList.add("CUC");currencyList.add("CUP");currencyList.add("CVE");
        currencyList.add("CZK");currencyList.add("DJF");currencyList.add("DKK");currencyList.add("DOP");
        currencyList.add("DZD");currencyList.add("EGP");currencyList.add("ERN");currencyList.add("ETB");
        currencyList.add("FJD");currencyList.add("FKP");currencyList.add("GBP");currencyList.add("GEL");
        currencyList.add("GGP");currencyList.add("GHS");currencyList.add("GIP");currencyList.add("GMD");
        currencyList.add("GNF");currencyList.add("GTQ");currencyList.add("GYD");currencyList.add("HKD");
        currencyList.add("HNL");currencyList.add("HRK");currencyList.add("HTG");currencyList.add("HUF");
        currencyList.add("IDR");currencyList.add("IQD");currencyList.add("IRR");currencyList.add("ISK");
        currencyList.add("ILS");currencyList.add("IMP");currencyList.add("INR");currencyList.add("IQD");
        currencyList.add("IRR");currencyList.add("ISK");currencyList.add("JEP");currencyList.add("JMD");
        currencyList.add("JOD");currencyList.add("JPY");currencyList.add("KES");currencyList.add("KGS");
        currencyList.add("KHR");currencyList.add("KMF");currencyList.add("KPW");currencyList.add("KRW");
        currencyList.add("KWD");currencyList.add("KYD");currencyList.add("KZT");currencyList.add("LAK");
        currencyList.add("LBP");currencyList.add("LKR");currencyList.add("LRD");currencyList.add("LSL");
        currencyList.add("LYD");currencyList.add("MAD");currencyList.add("MDL");currencyList.add("MGA");
        currencyList.add("MKD");currencyList.add("MMK");currencyList.add("MNT");currencyList.add("MOP");
        currencyList.add("MRO");currencyList.add("MUR");currencyList.add("MVR");currencyList.add("MWK");
        currencyList.add("MXN");currencyList.add("MYR");currencyList.add("MZN");currencyList.add("NAD");
        currencyList.add("NGN");currencyList.add("NIO");currencyList.add("NOK");currencyList.add("NPR");
        currencyList.add("NZD");currencyList.add("OMR");currencyList.add("PAB");currencyList.add("PEN");
        currencyList.add("PGK");currencyList.add("PHP");currencyList.add("PKR");currencyList.add("PLN");
        currencyList.add("PYG");currencyList.add("QAR");currencyList.add("RON");currencyList.add("RSD");
        currencyList.add("RUB");currencyList.add("RWF");currencyList.add("SAR");currencyList.add("SBD");
        currencyList.add("SCR");currencyList.add("SDG");currencyList.add("SEK");currencyList.add("SGD");
        currencyList.add("SHP");currencyList.add("SLL");currencyList.add("SOS");currencyList.add("SPL");
        currencyList.add("SRD");currencyList.add("STD");currencyList.add("SVC");currencyList.add("SYP");
        currencyList.add("SZL");currencyList.add("THB");currencyList.add("TJS");currencyList.add("TMT");
        currencyList.add("TND");currencyList.add("TOP");currencyList.add("TRY");currencyList.add("TTD");
        currencyList.add("TVD");currencyList.add("TWD");currencyList.add("TZS");currencyList.add("UAH");
        currencyList.add("UGX");currencyList.add("USD");currencyList.add("UYU");currencyList.add("UZS");
        currencyList.add("VEF");currencyList.add("VND");currencyList.add("VUV");currencyList.add("WST");
        currencyList.add("XAF");currencyList.add("XCD");currencyList.add("XDR");currencyList.add("XOF");
        currencyList.add("XPF");currencyList.add("YER");currencyList.add("ZAR");currencyList.add("ZMW");
        currencyList.add("ZWD");



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
        selectedCurrency= parent.getItemAtPosition(position).toString();
        SharedPreferences.Editor saveCurrency = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
        saveCurrency.putString("selectedCurrency", selectedCurrency);
        saveCurrency.commit();
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
