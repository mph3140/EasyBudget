package com.benoitletondor.easybudgetapp.helper;

public class CalculateMonthlyPaymentHelper {

    public static String calculateMonthlyPayment(double expense, double downPayment, double salesTax, double interest, int loanTerm){

        double totalPayment = (((expense * (1 + salesTax)) - downPayment)) * (1 + interest);

        double payment = totalPayment / loanTerm;
        String monthlyPayment = String.format("%.2f", payment);
        return monthlyPayment;
    }

}
