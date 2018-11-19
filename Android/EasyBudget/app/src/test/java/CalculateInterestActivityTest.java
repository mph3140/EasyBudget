import com.benoitletondor.easybudgetapp.helper.CalculateMonthlyPaymentHelper;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculateInterestActivityTest {

    @Test
    public void calculateMonthlyPaymentTest(){
        double expense = 1000;
        double downPayment = 500;
        double salesTax = .06;
        double interest = .15;
        int loanTerm = 12;

        String monthlyPayment = CalculateMonthlyPaymentHelper.calculateMonthlyPayment(expense, downPayment, salesTax, interest, loanTerm);

        assertEquals(monthlyPayment, "53.67");
    }

}
