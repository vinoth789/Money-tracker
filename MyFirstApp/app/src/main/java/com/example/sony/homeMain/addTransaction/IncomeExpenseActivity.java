package com.example.sony.homeMain.addTransaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.sony.homeMain.R;

/*public class IncomeExpenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_expense);
    }
}*/


public class IncomeExpenseActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_expense);

        // Spinner element
      /*  Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        *//*List<String> categories = new ArrayList<String>();
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");*//*

        // Creating adapter for spinner
        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this,
                R.array.transaction_type, android.R.layout.simple_spinner_item);
        //ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.array.transaction_type, android.R.layout.simple_spinner_item);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);*/
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        Intent intent = new Intent(this, AddTransactionDetailsActivity.class);
        boolean checked = ((RadioButton) view).isChecked();
        RadioButton selectIncome = (RadioButton) findViewById(R.id.radioButton);
        RadioButton selectExpense = (RadioButton) findViewById(R.id.radioButton2);
        String income = selectIncome.getText().toString();
        String expense = selectExpense.getText().toString();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton:
                if (checked)
                    intent.putExtra(EXTRA_MESSAGE, income);
                break;
            case R.id.radioButton2:
                if (checked)
                    intent.putExtra(EXTRA_MESSAGE, expense);
                break;
        }
        startActivity(intent);
    }

   /* @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }*/
}