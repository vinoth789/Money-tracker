package com.example.sony.homeMain.viewReport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sony.homeMain.R;
import com.example.sony.homeMain.dbConnection.LogTableHelper;
import com.example.sony.homeMain.userBean.ReportDetailsBean;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.name;

public class ViewReportActivity extends AppCompatActivity {

    LogTableHelper reportDetailsHelper;
    int listcounter=0;
    String dateStamp,txnAmount,txnNote,txnCategory,txnMode, txnDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_report);
        TextView recentTransactionDetails = (TextView) findViewById(R.id.transactionDetails);
        ArrayList<ReportDetailsBean> reportList = new ArrayList<ReportDetailsBean>();
        reportDetailsHelper = new LogTableHelper(getApplicationContext(), "moneyTrackerCC.db", null, 1);
        reportList = reportDetailsHelper.fetchReport();

        if(listcounter<reportList.size()){
            dateStamp = reportList.get(listcounter).getDateStamp();
            txnAmount = reportList.get(listcounter).getTxnAmount();
            txnNote = reportList.get(listcounter).getTxnNote();
            txnCategory = reportList.get(listcounter).getTxnCategory();
            txnMode = reportList.get(listcounter).getTxnMode();

            recentTransactionDetails.setText("");
            recentTransactionDetails.append(dateStamp+" " );
            recentTransactionDetails.append(txnMode+", " );
            recentTransactionDetails.append(txnCategory+", ");
            recentTransactionDetails.append(txnNote+"    ");
            recentTransactionDetails.append(txnAmount);

            listcounter++;
        }
        else{
            listcounter=0;
        }
    }
}
