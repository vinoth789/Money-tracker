package com.example.sony.homeMain;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sony.homeMain.addTransaction.IncomeExpenseActivity;
import com.example.sony.homeMain.dbConnection.LogTableHelper;
import com.example.sony.homeMain.login.LoginToHome;
import com.example.sony.homeMain.settings.SettingsActivity;
import com.example.sony.homeMain.userBean.ReportDetailsBean;
import com.example.sony.homeMain.viewReport.ViewReportActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends  AppCompatActivity   {

    Intent intent;
    String redirectToHome="failure";
    LogTableHelper reportDetailsHelper;
    String dateStamp,txnAmount,txnNote,txnCategory,txnMainCategory,txnMode, txnDay, currency;
    TextView recentTransactionDetails, prevMonIncAmt, currentMonIncAmt, nextMonIncAmt, prevMonExpAmt, currentMonExpAmt, nextMonExpAmt;
    int income =0;
    int expense = 0;
    int totalIncome =0;
    int totalExpense = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        boolean switchState = prefs.getBoolean("pinEnabled", false);
        //redirectToHome = prefs.getString("redirectToHome", "");
        Intent intent = getIntent();
        redirectToHome = intent.getStringExtra(LoginToHome.REDIRECT_TO_HOME);
        final TabHost tab = (TabHost) findViewById(android.R.id.tabhost);
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
                //TabHost tab = (TabHost) findViewById(android.R.id.tabhost);
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
                String currency2 = prefs.getString("selectedCurrency", "");
                recentTransactionDetails= (TextView) findViewById(R.id.currentMonRecentTxn);
                fetchMonthlyReport(1);
                currentMonIncAmt= (TextView) findViewById(R.id.cIncomeAmt);
                currentMonExpAmt= (TextView) findViewById(R.id.cExpenseAmt);
                currentMonIncAmt.setText("");
                currentMonIncAmt.append(income+" "+currency2);
                currentMonExpAmt.setText("");
                currentMonExpAmt.append(expense+" "+currency2);
                /**/

            }
        tab.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            @Override
            public void onTabChanged(String tabId) {
                String tabNumber;
                DateFormat dateFormat = new SimpleDateFormat("MM");
                Date date = new Date();
                Log.d("Month",dateFormat.format(date));

                int i = tab.getCurrentTab();

                if (i == 0) {
                    tabNumber ="tab1";
                    SharedPreferences prefs = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
                    String currency1 = prefs.getString("selectedCurrency", "");
                    recentTransactionDetails= (TextView) findViewById(R.id.prevMonRecentTxn);
                    totalIncome=0;
                    totalExpense=0;
                    fetchMonthlyReport(i);
                    prevMonIncAmt= (TextView) findViewById(R.id.pIncomeAmt);
                    prevMonExpAmt= (TextView) findViewById(R.id.pExpenseAmt);
                    prevMonIncAmt.setText("");
                    prevMonIncAmt.append(totalIncome+" "+currency1);
                    prevMonExpAmt.setText("");
                    prevMonExpAmt.append(totalExpense+" "+currency1);
                }
                else if (i == 1) {
                    tabNumber ="tab2";
                    SharedPreferences prefs = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
                    String currency2 = prefs.getString("selectedCurrency", "");
                    recentTransactionDetails= (TextView) findViewById(R.id.currentMonRecentTxn);
                    totalIncome=0;
                    totalExpense=0;
                    fetchMonthlyReport(i);
                    currentMonIncAmt= (TextView) findViewById(R.id.cIncomeAmt);
                    currentMonExpAmt= (TextView) findViewById(R.id.cExpenseAmt);
                    currentMonIncAmt.setText("");
                    currentMonIncAmt.append(totalIncome+" "+currency2);
                    currentMonExpAmt.setText("");
                    currentMonExpAmt.append(totalExpense+" "+currency2);
                }
                else if (i == 2) {
                    tabNumber ="tab3";
                    SharedPreferences prefs = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
                    String currency3 = prefs.getString("selectedCurrency", "");
                    recentTransactionDetails= (TextView) findViewById(R.id.nextMonRecentTxn);
                    totalIncome=0;
                    totalExpense=0;
                    fetchMonthlyReport(i);
                    nextMonIncAmt= (TextView) findViewById(R.id.nIncomeAmt);
                    nextMonExpAmt= (TextView) findViewById(R.id.nExpenseAmt);
                    nextMonIncAmt.setText("");
                    nextMonIncAmt.append(totalIncome+" "+currency3);
                    nextMonExpAmt.setText("");
                    nextMonExpAmt.append(totalExpense+" "+currency3);
                }

            }
        });

    }

    public ArrayList<ReportDetailsBean> fetchMonthlyReport(int j) {

        ArrayList<ReportDetailsBean> reportList = new ArrayList<ReportDetailsBean>();
        reportDetailsHelper = new LogTableHelper(getApplicationContext(), "moneyTrackerCC.db", null, 1);
        SharedPreferences prefs = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        currency = prefs.getString("selectedCurrency", "");
        reportList = reportDetailsHelper.fetchReportMonthly(j);
        recentTransactionDetails.setText("");
        for(int i=0; i<reportList.size(); i++){
            dateStamp = reportList.get(i).getDateStamp();
            txnAmount = reportList.get(i).getTxnAmount();
            txnNote = reportList.get(i).getTxnNote();
            txnCategory = reportList.get(i).getTxnCategory();
            txnMainCategory =reportList.get(i).getTxnMainCategory();
            txnMode = reportList.get(i).getTxnMode();
            if(txnMainCategory.equalsIgnoreCase("income")){
                income = Integer.parseInt(txnAmount);
                totalIncome += income;
            }else{
                expense = Integer.parseInt(txnAmount);
                totalExpense += expense;
            }

            recentTransactionDetails.append(dateStamp+"      " );
            recentTransactionDetails.append(txnAmount+" "+currency+" ,");
            recentTransactionDetails.append(txnMode+", " );
            recentTransactionDetails.append(txnCategory+", ");
            recentTransactionDetails.append(txnNote);
            recentTransactionDetails.append("\n\n");

        }
        return reportList;
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
