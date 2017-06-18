package com.example.sony.homeMain.viewReport;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sony.homeMain.R;
import com.example.sony.homeMain.dbConnection.LogTableHelper;
import com.example.sony.homeMain.userBean.ReportDetailsBean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ViewReportActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    LogTableHelper reportDetailsHelper;
    String dateStamp,txnAmount,txnNote,txnCategory,txnMainCategory,txnMode, txnDay, currency, selectedCategory;
    private Calendar calendar;
    private int year, month, day;
    EditText fromDate, toDate;
    View selectFromDate,selectToDate;
    TextView recentTransactionDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_report);
        recentTransactionDetails = (TextView) findViewById(R.id.transactionDetails);
        SharedPreferences prefs = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        currency = prefs.getString("selectedCurrency", "");
        ArrayList<ReportDetailsBean> reportList = new ArrayList<ReportDetailsBean>();
        reportDetailsHelper = new LogTableHelper(getApplicationContext(), "moneyTrackerCC.db", null, 1);
        String fromDateFilter = null;
        String toDateFilter = null;
        reportList = reportDetailsHelper.fetchReport(fromDateFilter,toDateFilter, selectedCategory);
        recentTransactionDetails.setText("");
        for(int i=0; i<reportList.size(); i++){
            dateStamp = reportList.get(i).getDateStamp();
            txnAmount = reportList.get(i).getTxnAmount();
            txnNote = reportList.get(i).getTxnNote();
            txnCategory = reportList.get(i).getTxnCategory();
            txnMainCategory =reportList.get(i).getTxnMainCategory();
            txnMode = reportList.get(i).getTxnMode();


            recentTransactionDetails.append(dateStamp+"      " );
            recentTransactionDetails.append(txnAmount+" "+currency+" ,");
            recentTransactionDetails.append(txnMode+", " );
            recentTransactionDetails.append(txnCategory+", ");
            recentTransactionDetails.append(txnNote);
            recentTransactionDetails.append("\n\n");

        }
        Set<String> categoryList = prefs.getStringSet("categoryList", null);
        Iterator iterator = categoryList.iterator();
        List<String> subCategoryList = new ArrayList<String>();
        subCategoryList.add("");
        while (iterator.hasNext()){
            String items = (String) iterator.next();
            subCategoryList.add(items);
        }
        Spinner spinner = (Spinner) findViewById(R.id.categoryFilterSpinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subCategoryList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        fromDate = (EditText) findViewById(R.id.txnFromDate);
        fromDate.setEnabled(false);
        toDate = (EditText) findViewById(R.id.txnToDate);
        toDate.setEnabled(false);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedCategory = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void searchByFilter(View view) {
        String fromDateFilter = fromDate.getText().toString();
        String toDateFilter = toDate.getText().toString();
        ArrayList<ReportDetailsBean> filteredReportList = new ArrayList<ReportDetailsBean>();
        reportDetailsHelper = new LogTableHelper(getApplicationContext(), "moneyTrackerCC.db", null, 1);
        String [] dateFromFormat,dateToFormat;
        String day, month, day1,month1;
        dateFromFormat = fromDateFilter.split("/");
        if(dateFromFormat[0].length()<2){
            day = 0+dateFromFormat[0];
        }else{
            day = dateFromFormat[0];
        }
        if(dateFromFormat[1].length()<2){
            month = 0+dateFromFormat[1];
        }else{
            month = dateFromFormat[1];
        }
        dateToFormat = toDateFilter.split("/");
        if(dateToFormat[0].length()<2){
            day1 = 0+dateToFormat[0];
        }else{
            day1 = dateToFormat[0];
        }
        if(dateToFormat[1].length()<2){
            month1 = 0+dateToFormat[1];
        }else{
            month1 = dateToFormat[1];
        }
        String selectedFromDate = dateFromFormat[2]+"-"+month+"-"+day;
        String selectedToDate = dateToFormat[2]+"-"+month1+"-"+day1;
        if(fromDate != null && toDate != null || selectedCategory != null ){

            filteredReportList = reportDetailsHelper.fetchReport(selectedFromDate,selectedToDate, selectedCategory);
            recentTransactionDetails.setText("");
            for(int i=0; i<filteredReportList.size(); i++){
                dateStamp = filteredReportList.get(i).getDateStamp();
                txnAmount = filteredReportList.get(i).getTxnAmount();
                txnNote = filteredReportList.get(i).getTxnNote();
                txnCategory = filteredReportList.get(i).getTxnCategory();
                txnMainCategory =filteredReportList.get(i).getTxnMainCategory();
                txnMode = filteredReportList.get(i).getTxnMode();


                recentTransactionDetails.append(dateStamp+"      " );
                recentTransactionDetails.append(txnAmount+" "+currency+" ,");
                recentTransactionDetails.append(txnMode+", " );
                recentTransactionDetails.append(txnCategory+", ");
                recentTransactionDetails.append(txnNote);
                recentTransactionDetails.append("\n\n");

            }
        }else{
            Toast.makeText(getApplicationContext(), "Please enter valid date or category ", Toast.LENGTH_LONG).show();
        }



    }

    @SuppressWarnings("deprecation")
    public void setFilterDate(View view) {
        selectFromDate = view.findViewById(R.id.selectFromDate);
        selectToDate = view.findViewById(R.id.selectToDate);
        showDialog(999);

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        if(selectFromDate != null){
            fromDate.setText(new StringBuilder().append(day).append("/")
                    .append(month).append("/").append(year));
        }else if(selectToDate != null){
            toDate.setText(new StringBuilder().append(day).append("/")
                    .append(month).append("/").append(year));
        }

    }
}
