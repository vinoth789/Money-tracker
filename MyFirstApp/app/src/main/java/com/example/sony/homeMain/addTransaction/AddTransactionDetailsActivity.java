package com.example.sony.homeMain.addTransaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sony.homeMain.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.sony.homeMain.dbConnection.LogTableHelper;

public class AddTransactionDetailsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    EditText amount,note;
    Button save;
    String selectedCategory;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction_details);

        Intent intent = getIntent();
        String transactionType = intent.getStringExtra(IncomeExpenseActivity.EXTRA_MESSAGE);
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

        // Creating adapter for spinner
        //ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this,
               // R.array.transaction_type, android.R.layout.simple_spinner_item);
        ArrayAdapter<String> dataAdapter;
        if(transactionType.equalsIgnoreCase("income")) {
            dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, incomeCategories);
        }else {
            dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, expenseCategories);
        }

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        amount=(EditText) findViewById(R.id.txnAmount);
        note=(EditText) findViewById(R.id.txnNote);
        radioGroup = (RadioGroup) findViewById(R.id.txnRadioGroup);
        /*DatePicker datePicker = (DatePicker) findViewById(R.id.txnDate);
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();*/

        save=(Button) findViewById(R.id.txnSave);
        save.setOnClickListener(this);
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
            if (amount.getText().toString().length() > 0 && note.getText().toString().length() > 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String currentDateandTime = sdf.format(new Date());
                LogTableHelper transaction = new LogTableHelper(getApplicationContext(), "moneyTracker.db", null, 1);
                transaction.insertTxnDetails(amountVal, selectedCategory,note.getText().toString(),currentDateandTime,selectedPaymentMethod);
                Toast.makeText(getApplicationContext(), "Transaction details successfully added at " + currentDateandTime, Toast.LENGTH_LONG).show();

                finish();
                //Intent i=new Intent(getApplicationContext(), MenuScreen.class);
                //startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "Summary or Text is missing", Toast.LENGTH_LONG).show();
            }
        }
    }
}
