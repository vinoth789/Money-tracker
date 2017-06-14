package com.example.sony.homeMain;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.sony.homeMain.addTransaction.IncomeExpenseActivity;
import com.example.sony.homeMain.login.LoginToHome;
import com.example.sony.homeMain.settings.SettingsActivity;
import com.example.sony.homeMain.viewReport.ViewReportActivity;

public class MainActivity extends  AppCompatActivity   {

    public static final String SELECTED_TRANSACTION_TYPE = "com.example.myfirstapp.SELECTEDOPTION";
    Intent intent;
    String redirectToHome="failure";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        boolean switchState = prefs.getBoolean("pinEnabled", false);
        //redirectToHome = prefs.getString("redirectToHome", "");
        Intent intent = getIntent();
        redirectToHome = intent.getStringExtra(LoginToHome.REDIRECT_TO_HOME);
        if(redirectToHome == null){
            redirectToHome="failure";
        }

            if (switchState == true && redirectToHome.equalsIgnoreCase("failure"))
            {
                intent = new Intent(this, LoginToHome.class);
                startActivity(intent);
            }
            else
            {
                TabHost tab = (TabHost) findViewById(android.R.id.tabhost);
                tab.setup();


                TabHost.TabSpec previousMonth = tab.newTabSpec("PreviousMonth");
                previousMonth.setIndicator("Previous Month");
                previousMonth.setContent(R.id.PreviousMonth);
                tab.addTab(previousMonth);

                TabHost.TabSpec currentMonth = tab.newTabSpec("CurrentMonth");
                currentMonth.setIndicator("Current Month");
                currentMonth.setContent(R.id.CurrentMonth);
                tab.addTab(currentMonth);

                TabHost.TabSpec nextMonth = tab.newTabSpec("NextMonth");
                nextMonth.setIndicator("Next Month");
                nextMonth.setContent(R.id.NextMonth);
                tab.addTab(nextMonth);
                tab.setCurrentTabByTag("CurrentMonth");

            }

    }
    public void redirectIncomeExpense(View view) {
        intent = new Intent(this, IncomeExpenseActivity.class);
        startActivity(intent);
    }
    public void redirectToSettings(View view) {
        intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
    public void redirectToReport(View view) {
        intent = new Intent(this, ViewReportActivity.class);
        startActivity(intent);
    }

   /* @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        Intent intent = new Intent(this, AddTransactionDetailsActivity.class );
        String item = parent.getItemAtPosition(position).toString();
        intent.putExtra(SELECTED_TRANSACTION_TYPE,item);
        startActivity(intent);
        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }*/

    /*public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        Intent intent = new Intent(this, AddTransactionDetailsActivity.class );
        boolean checked = ((RadioButton) view).isChecked();
        RadioButton selectIncome = (RadioButton) findViewById(R.id.radioButton);
        RadioButton selectExpense = (RadioButton) findViewById(R.id.radioButton2);
        String income = selectIncome.getText().toString();
        String expense = selectExpense.getText().toString();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    intent.putExtra(EXTRA_MESSAGE,income);
                    break;
            case R.id.radioButton2:
                if (checked)
                    intent.putExtra(EXTRA_MESSAGE,expense);
                    break;
        }
        startActivity(intent);
    }*/



   /* public void selectIncomeExpense(View view){
        Intent intent = new Intent(this, AddTransactionDetailsActivity.class );
        RadioButton selectIncome = (RadioButton) findViewById(R.id.radioButton);
        RadioButton selectExpense = (RadioButton) findViewById(R.id.radioButton2);
        String income = selectIncome.getText().toString();
        selectIncome
        if(incomeExpense == "income"){
            intent.putExtra(EXTRA_MESSAGE,incomeExpense);
        }else{
            intent.putExtra(EXTRA_MESSAGE,incomeExpense);
        }
        startActivity(intent);

    }*/
}
