package com.benoitletondor.easybudgetapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.benoitletondor.easybudgetapp.R;
import com.benoitletondor.easybudgetapp.helper.CalculateMonthlyPaymentHelper;

public class CalculateInterestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_interest);
        Toolbar toolbar = findViewById(R.id.calculate_Interest_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Button button = findViewById(R.id.calculate_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String monthlyPayment = CalculateMonthlyPaymentHelper.calculateMonthlyPayment(getUiExpenseInDouble(), getUiDownPaymentInDouble(), getUiSalesTaxInDouble(), getUiInterestInDouble(), getUiLoanTermInInt());

                TextView monthlyEstimateView = findViewById(R.id.monthly_estimate);
                monthlyEstimateView.setText("$" + monthlyPayment + " per month.");
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if( id == android.R.id.home ) // Back button of the actionbar
        {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    public double calculateMonthlyPayment(double expense, double downPayment, double salesTax, double interest, int loanTerm){
//
//        double totalPayment = (((expense * (1 + salesTax)) - downPayment)) * (1 + interest);
//
//        return totalPayment / loanTerm;
//    }

    public double getUiExpenseInDouble(){
        String expenseString = ((EditText)findViewById(R.id.expense_amount_edittext)).getText().toString();
        double expense = Double.parseDouble(expenseString);
        return expense;
    }

    public double getUiDownPaymentInDouble(){
        String downPaymentString = ((EditText)findViewById(R.id.downpayment_edittext)).getText().toString();
        double downPayment = Double.parseDouble(downPaymentString);

        return downPayment;
    }

    public double getUiSalesTaxInDouble(){
        String salesTaxString = ((EditText)findViewById(R.id.sales_tax_edittext)).getText().toString();
        double salesTax = Double.parseDouble(salesTaxString);

        return salesTax;
    }

    public double getUiInterestInDouble(){
        String interestString = ((EditText)findViewById(R.id.interest_edittext)).getText().toString();
        double interest = Double.parseDouble(interestString);

        return interest;
    }

    public int getUiLoanTermInInt(){
        String loanTermString = ((EditText)findViewById(R.id.loan_term_edittext)).getText().toString();
        int loanTerm = Integer.parseInt(loanTermString);

        return loanTerm;
    }
}