package com.example.sony.homeMain.userBean;

/**
 * Created by sony on 14-06-2017.
 */

public class ReportDetailsBean {

    String dateStamp;
    String txnAmount;
    String txnNote;
    String txnCategory;
    String txnMode;
    String day;

    public String getDateStamp() {
        return dateStamp;
    }

    public void setDateStamp(String dateStamp) {
        this.dateStamp = dateStamp;
    }

    public String getTxnAmount() {
        return txnAmount;
    }

    public void setTxnAmount(String txnAmount) {
        this.txnAmount = txnAmount;
    }

    public String getTxnNote() {
        return txnNote;
    }

    public void setTxnNote(String txnNote) {
        this.txnNote = txnNote;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTxnCategory() {
        return txnCategory;
    }

    public void setTxnCategory(String txnCategory) {
        this.txnCategory = txnCategory;
    }

    public String getTxnMode() {
        return txnMode;
    }

    public void setTxnMode(String txnMode) {
        this.txnMode = txnMode;
    }
}
