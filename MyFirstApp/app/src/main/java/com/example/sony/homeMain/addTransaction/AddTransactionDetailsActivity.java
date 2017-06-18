package com.example.sony.homeMain.addTransaction;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.RelativeDateTimeFormatter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sony.homeMain.MainActivity;
import com.example.sony.homeMain.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.example.sony.homeMain.dbConnection.LogTableHelper;

import static android.R.attr.format;

public class AddTransactionDetailsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    public static final String REDIRECT_TO_HOME = "com.example.myfirstapp.HOME";
    EditText amount,note;
    Button save;
    String selectedCategory, transactionType;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private int year, month, day;
    private DatePicker datePicker;
    Intent intent;
    private Calendar calendar;
    private TextView selectedCurrency;
    EditText selectDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction_details);
        selectDate = (EditText) findViewById(R.id.txnDate);
        selectDate.setEnabled(false);
        Intent intent = getIntent();
        transactionType = intent.getStringExtra(IncomeExpenseActivity.EXTRA_MESSAGE);
        SharedPreferences prefs = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        // String transactionType = intent.getStringExtra(MainActivity.SELECTED_TRANSACTION_TYPE);
        //TextView amount = (TextView)findViewById(R.id.txnAmount);
        //textView.setText(0);

        Spinner spinner = (Spinner) findViewById(R.id.txnCategory);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> incomeCategories = new ArrayList<String>();
        incomeCategories.add("Salary");
        incomeCategories.add("Interest");
        incomeCategories.add("Gifts");
        //incomeCategories.add("Education");
        //incomeCategories.add("Personal");
        //incomeCategories.add("Travel");

        List<String> expenseCategories = new ArrayList<String>();
        expenseCategories.add("Shopping");
        expenseCategories.add("Health");
        expenseCategories.add("Food and Beverages");
        expenseCategories.add("Education");
        expenseCategories.add("Personal");
        expenseCategories.add("Travel");

        List<String> subCategories = new ArrayList<String>();
        subCategories.addAll(incomeCategories);
        subCategories.addAll(expenseCategories);

        SharedPreferences.Editor editor = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
        Set<String> categorySet = new HashSet<String>();
        categorySet.addAll(subCategories);
        editor.putStringSet("categoryList", categorySet);
        editor.commit();


        // Creating adapter for spinner
        //ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this,
        // R.array.transaction_type, android.R.layout.simple_spinner_item);
        ArrayAdapter<String> dataAdapter;
        if (transactionType.equalsIgnoreCase("income")) {
            dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, incomeCategories);
        } else {
            dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, expenseCategories);
        }

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        amount = (EditText) findViewById(R.id.txnAmount);
        note = (EditText) findViewById(R.id.txnNote);

        radioGroup = (RadioGroup) findViewById(R.id.txnRadioGroup);
        selectedCurrency = (TextView) findViewById(R.id.selectedCurrency);

        String currency = prefs.getString("selectedCurrency", "");
        selectedCurrency.setText(new StringBuilder().append(currency));

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);


        //showDate(year, month+1, day);
        save=(Button) findViewById(R.id.txnSave);
        save.setOnClickListener(this);
    }
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
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
        selectDate.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         selectedCategory = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    @Override
    public void onClick(View v) {

        int amountVal = Integer.parseInt( amount.getText().toString() );
        if(v==save) {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            radioButton = (RadioButton) findViewById(selectedId);
            String selectedPaymentMethod = radioButton.getText().toString();
            String selectedDate = selectDate.getText().toString();
            Date myDate = null;
            String[] dateFormat;
            String day,month,year;
            if (amount.getText().toString().length() > 0 && note.getText().toString().length() > 0 && selectedDate.length() > 0) {
                SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-DD");
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                /*try {
                    myDate = (Date) sdf1.parseObject(selectedDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }*/
                dateFormat = selectedDate.split("/");
                if(dateFormat[0].length()<2){
                    day = 0+dateFormat[0];
                }else{
                    day = dateFormat[0];
                }
                if(dateFormat[1].length()<2){
                    month = 0+dateFormat[1];
                }else{
                    month = dateFormat[1];
                }

                String selectedDateAndTime = dateFormat[2]+"-"+month+"-"+day;
                /*Date newDate = format.parse(selectedDate);
                Date newDate = sdf.parse(selectedDate);*/
                //String selectedDateAndTime = sdf.format(myDate);
                //String selectedDateAndTime = sdf.format(selectedDate);
                String currentDateAndTime = sdf.format(new Date());
                LogTableHelper transaction = new LogTableHelper(getApplicationContext(), "moneyTracker.db", null, 1);
                transaction.insertTxnDetails(amountVal, selectedCategory, transactionType, note.getText().toString(),selectedDateAndTime,selectedPaymentMethod);
                Toast.makeText(getApplicationContext(), "Transaction details successfully added at " + currentDateAndTime, Toast.LENGTH_LONG).show();

                finish();
                //Intent i=new Intent(getApplicationContext(), MenuScreen.class);
                //startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "Please enter all the details", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void redirectToHome(View view) {
        intent = new Intent(this, MainActivity.class);
        intent.putExtra(REDIRECT_TO_HOME, "success");
        startActivity(intent);
    }
}
