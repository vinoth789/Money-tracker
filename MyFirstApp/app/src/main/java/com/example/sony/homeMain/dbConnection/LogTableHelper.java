package com.example.sony.homeMain.dbConnection;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.sony.homeMain.userBean.ReportDetailsBean;
import com.example.sony.homeMain.userBean.UserDetails;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by sony on 09-06-2017.
 */

public class LogTableHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="moneyTrackerCC.db";
    private static final int DATABASE_VERSION=2;



    public static final String TRANSACTION_TABLE="moneyTracker";
    public static final String TXN_ID="txn_id";
    public static final String TXN_AMOUNT="amount";
    public static final String TXN_CATEGORY="category";
    public static final String TXN_NOTE="note";
    public static final String TXN_DATE="txn_date";
    public static final String TXN_PAYMENT_METHOD="payment_method";

    public static final String USER_TABLE="user_details";
    public static final String USER_ID="user_id";
    public static final String USER_USERNAME="mtUsername";
    public static final String USER_PASSWORD="mtPassword";
    private static final String MY_DEBUG_TAG = "debugTag";


    public LogTableHelper(Context context, String name, CursorFactory factory,
                          int version) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    public LogTableHelper(Context context ){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //db=this.getReadableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        SqliteHelper.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        SqliteHelper.onUpgrade(db, oldVersion, newVersion);
    }

    public boolean insertTxnDetails(int amount, String category, String note, String txn_date,String payment_method)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("amount", amount);
        contentValues.put("category", category);
        contentValues.put("note", note);
        contentValues.put("payment_method", payment_method);
        contentValues.put("txn_date", txn_date);
        db.insert("transaction", null, contentValues);
        return true;
    }

    public void insertContact(UserDetails userDetails){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(USER_USERNAME,userDetails.getUname());
        values.put(USER_PASSWORD,userDetails.getPwd());
        db.insert(USER_TABLE, null, values);
        db.close();
    }

    public Cursor validatePIN(String uname){
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select mtPassword from " + USER_TABLE + " where mtUsername ='" +uname+"'" ;
        Cursor cursor=db.rawQuery(query, null);
        return cursor;
    }

    public boolean updatePIN(String uname, String password){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(USER_PASSWORD,password);
        db.update(USER_TABLE,contentValues,"mtUsername ='" +uname+"'",null);
        return true;
    }

    public ArrayList<ReportDetailsBean> fetchReport() {
        String dateStamp,txnAmount,txnNote,txnCategory,txnMode, txnDay;
        SQLiteDatabase db=this.getReadableDatabase();
        ArrayList<ReportDetailsBean> reportList = new ArrayList<ReportDetailsBean>();
        ReportDetailsBean reportDetails = new ReportDetailsBean();
        Cursor mCursor = db.query(TRANSACTION_TABLE, new String[] {TXN_ID,
                        TXN_AMOUNT, TXN_CATEGORY,TXN_NOTE,TXN_PAYMENT_METHOD,TXN_DATE},
                null, null, null, null, null);
        if (mCursor != null) {
            while (mCursor.moveToNext()) {
                dateStamp = mCursor.getString(mCursor.getColumnIndex(TXN_DATE));
                txnAmount = mCursor.getString(mCursor.getColumnIndex(TXN_AMOUNT));
                txnNote = mCursor.getString(mCursor.getColumnIndex(TXN_NOTE));
                txnCategory = mCursor.getString(mCursor.getColumnIndex(TXN_CATEGORY));
                txnMode = mCursor.getString(mCursor.getColumnIndex(TXN_PAYMENT_METHOD));
                //txnDay = mCursor.getString(mCursor.getColumnIndex("date"));

                try {
                    reportDetails.setDateStamp(dateStamp);
                    reportDetails.setTxnAmount(txnAmount);
                    reportDetails.setTxnNote(txnNote);
                    reportDetails.setTxnCategory(txnCategory);
                    reportDetails.setTxnMode(txnMode);
                    //reportDetails.setTxnMode(txnDay);
                    reportList.add(reportDetails);
                } catch (Exception e) {
                    Log.e(MY_DEBUG_TAG, "Error " + e.toString());
                }

            }
        }
        return reportList;
    }

    /*public boolean insertLog(String logtitle,String logsummary,String date) {

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("title",logtitle);
        contentValues.put("summary",logsummary);
        contentValues.put("date",date);

        db.insert("log",null,contentValues);
        return true;
    }*/

    /*public boolean updateLog(String id,String ulogtitle,String ulogsummary)
    {
		*//*
		 * UPDATE table_name
         *  SET column1 = value1, column2 = value2...., columnN = valueN
         *  WHERE [condition];
		 *//*
        //	String updateQuery="UPDATE "+TABLE_LOG+" SET "+LOG_TITLE+"='"+ulogtitle+"'"+","+LOG_DATA+"='"+ulogsummary+"'"+" WHERE "+LOG_ID+"="+id;

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put("title",ulogtitle);
        contentValues.put("summary", ulogsummary);

        db.update("log",contentValues,"_id="+id,null);
        return true;

    }*/

    public Cursor fetchParticular(String id)
    {
        String sql="Select * from log where _id="+id;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cr=db.rawQuery(sql,null);
        return cr;
    }

    /*public Cursor fetchReport() {
        // TODO Auto-generated method stub
        SQLiteDatabase db=this.getReadableDatabase();
        //	Cursor cr=db.rawQuery("select * from log",null);
        //	return cr.getCount();
        Cursor mCursor = db.query(TRANSACTION_TABLE, new String[] {TXN_ID,
                        TXN_AMOUNT, TXN_CATEGORY,TXN_NOTE,TXN_PAYMENT_METHOD,TXN_DATE},
                null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }*/

    public Cursor fetchAll()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cr=db.rawQuery("select * from log",null);
        return cr;
    }

    public Boolean Delete(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TRANSACTION_TABLE, TXN_ID + "=" + id, null);
        return true;
    }
}
