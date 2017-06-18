package com.example.sony.homeMain.dbConnection;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by sony on 09-06-2017.
 */

public class SqliteHelper {
    public static final String DATABASE_NAME="moneyTracker";
    public static final String TRANSACTION_TABLE="moneyTracker";
    public static final String TXN_ID="txn_id";
    public static final String TXN_AMOUNT="amount";
    public static final String TXN_CATEGORY="category";
    public static final String TXN_MAIN_CATEGORY="transaction_category";
    public static final String TXN_NOTE="note";
    public static final String TXN_DATE="txn_date";
    public static final String TXN_PAYMENT_METHOD="payment_method";

    public static final String USER_TABLE="user_details";
    public static final String USER_ID="user_id";
    public static final String USER_USERNAME="mtUsername";
    public static final String USER_PASSWORD="mtPassword";

    private static final String DATABASE_CREATE="create table "
            + TRANSACTION_TABLE
            + " ("
            + TXN_ID + " integer primary key autoincrement,"
            + TXN_AMOUNT + " text not null,"
            + TXN_CATEGORY + " text not null, "
            + TXN_MAIN_CATEGORY + " text not null, "
            + TXN_NOTE +" text not null,"
            + TXN_PAYMENT_METHOD +" text not null,"
            + TXN_DATE +" text not null"
            + ");";

    private static final String USER_DETAILS_CREATE ="create table "
                   + USER_TABLE
                   + " ("
                   + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                   + USER_USERNAME + " text not null,"
                   + USER_PASSWORD + " text not null"
                   + ");";



    public static void onCreate(SQLiteDatabase database)
    {
        database.execSQL(DATABASE_CREATE);
        database.execSQL(USER_DETAILS_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase database,int oldversion,int newversion)
    {
        database.execSQL("DROP TABLE IF EXISTS " + TRANSACTION_TABLE);
        database.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(database);
    }
}
