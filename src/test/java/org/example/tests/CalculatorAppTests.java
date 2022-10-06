package org.example.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.example.CalculatorApp;

public class CalculatorAppTests {
    @Test
    public void testIsValidExpression() {
        String input = "";

        //test correct expression
        input = "12435+34569-12345*10+50";
        assertEquals("Checking correct expression", 0, CalculatorApp.isValidExpression(input));

        //test empty expression
        input = " ";
        assertEquals("Checking empty expression", 1, CalculatorApp.isValidExpression(input));

        //test single value
        input = "3";
        assertEquals("Checking single value", 0, CalculatorApp.isValidExpression(input));

        //test operator at the beginning
        input = "+5-7*5";
        assertEquals("Checking operator at the start", 1, CalculatorApp.isValidExpression(input));

        //test operator at the end
        input = "5-7*5+";
        assertEquals("Checking operator at the end", 1, CalculatorApp.isValidExpression(input));

        //test double operator
        input = "5-7*5++4 ";
        assertEquals("Checking double operator", 1, CalculatorApp.isValidExpression(input));

        //test unknown character
        input = "10/2 + f";
        assertEquals("Checking unknown character", 2, CalculatorApp.isValidExpression(input));

        //test decimal values
        input = "3.5*6+10.2";
        assertEquals("Checking decimal values", 3, CalculatorApp.isValidExpression(input));

        //test leading zeros
        input = "3+067-56";
        assertEquals("Checking leading zero", 4, CalculatorApp.isValidExpression(input));
    }

}
