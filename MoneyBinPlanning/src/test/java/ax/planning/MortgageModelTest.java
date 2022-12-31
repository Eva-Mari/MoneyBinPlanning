package ax.planning;

import static org.junit.jupiter.api.Assertions.*;

class MortgageModelTest {


    @org.junit.jupiter.api.Test
    void calculateMonthlyInterestrate() {

        double expected = 0.001;
        double result = MortgageModel.calculateMonthlyInterestrate(1.2);
        assertEquals(expected,result);

        expected = 0.0035;
        result = MortgageModel.calculateMonthlyInterestrate(4.2);
        assertEquals(expected,result);

        expected = 0.007225;
        result = MortgageModel.calculateMonthlyInterestrate(8.67);
        assertEquals(expected,result);

        expected = 0.005;
        result = MortgageModel.calculateMonthlyInterestrate(6);
        assertEquals(expected,result);

    }

    @org.junit.jupiter.api.Test
    void calculateNumberOfPayments() {

        int expected = 24;
        double result = MortgageModel.calculateNumberOfPayments(2);
        assertEquals(expected,result);

        expected = 72;
        result = MortgageModel.calculateNumberOfPayments(6);
        assertEquals(expected,result);

        expected = 48;
        result = MortgageModel.calculateNumberOfPayments(4);
        assertEquals(expected,result);

        int notExpected = 59;
        result = MortgageModel.calculateNumberOfPayments(5);
        assertNotEquals(notExpected,result);
    }

    @org.junit.jupiter.api.Test
    void calculatePowerOf() {

        double expected = 1;
        double result = MortgageModel.calculatePowerOf(6, 0);
        assertEquals(expected, result);

        expected = 3125;
        result = MortgageModel.calculatePowerOf(5,5);
        assertEquals(expected, result);

        assertThrows(IllegalArgumentException.class, ()-> MortgageModel.calculatePowerOf(5, -5));
    }

    @org.junit.jupiter.api.Test
    void calculateMortageFormula() {

        //max tolerance/delta accepted between the expected + result value, to still be considered equals
        double tolerance = 1e-8;

        MortgageModel mortgageModel = new MortgageModel(5, 1000, 2);
        double expected = 43.871389734068;
        double result = mortgageModel.calculateMortgageFormula();
        assertEquals(expected, result, tolerance);

        expected = 59.218568828681;
        MortgageModel mortgageModel2 = new MortgageModel(8.67, 1300.55, 2);
        result = mortgageModel2.calculateMortgageFormula();
        assertEquals(expected, result, tolerance);

        expected = 46.970058095871;
        MortgageModel mortgageModel3 = new MortgageModel(6, 2000, 4);
        result = mortgageModel3.calculateMortgageFormula();
        assertEquals(expected, result, tolerance);


    }

}