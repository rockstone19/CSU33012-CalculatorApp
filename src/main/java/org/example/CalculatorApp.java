package org.example;

public class CalculatorApp {
    public static void main(String[] args)
    {
        System.out.println("hello there!!" + isValidExpression("3+10*3"));
    }


    /*
     Returns int code based on result
     *0 = isValidExpression
     *1 = isn't valid: operator issue or empty expression
     *2 = isn't valid: unknown character
     *3 = isn't valid: decimal numbers
     *4 = isn't valid: leading 0*/
    public static int isValidExpression(String expression)
    {
        boolean canBeOperator = false;

        //Single character expression
        if(expression.length() == 1)
        {
            if(isNumber(expression.charAt(0)))
                return 0;
            else
                return 1;
        }
        //Go through expression, if not valid, return false
        for(int i = 0; i < expression.length(); i++)
        {
            char currChar = expression.charAt(i);
            //If it's an operator
            if(currChar == '+' || currChar == '-' || currChar == '*')
            {
                //If it isn't proper operator placement
                if(!canBeOperator)
                    return 1;
                    //Final charatcer cannot be operator
                else if(i == expression.length()-1)
                    return 1;
                    //Otherwise, set canBeOperator to false (prevent double operators)
                else
                    canBeOperator = false;
            }
            //If it's a number, reset canBeOperator
            else if(isNumber(currChar))
            {
                //Zero handling
                if(currChar == '0')
                {
                    //Leading 0 handling (make sure expression is 0+/-/* ...)
                    if(i == 0)
                    {
                        if(!isOperator(expression.charAt(i+1)))
                            return 4;
                    }
                    //Check if expression isn't +/-/*0... (invalid)
                    else if(isOperator(expression.charAt(i-1)))
                    {
                        //Not final character in string (avoid errors)
                        if(i < expression.length()-1)
                        {
                            //If expression isn't operating on 0 (e.g. +0+)
                            if(!isOperator(expression.charAt(i+1)))
                                return 4;
                        }
                    }
                }
                canBeOperator = true;
            }
            //If it is a period (decimal)
            else if(currChar == '.')
                return 3;
                //If it isn't a valid character
            else
                return 2;
        }
        //Check to see if last character ISN'T operator
        if(isOperator(expression.charAt(expression.length()-1)))
            return 1;
        //Else, return 0 (is valid expression)
        return 0;
    }

    public static boolean isOperator(char currChar)
    {
        if(currChar == '+' || currChar == '-' || currChar == '*')
            return true;
        return false;
    }

    public static boolean isNumber(char currChar)
    {
        if(currChar == '1' ||currChar == '2' || currChar == '3' || currChar == '4' || currChar == '5' ||
                currChar == '6' || currChar == '7' ||currChar == '8' || currChar == '9' ||currChar == '0')
            return true;
        return false;
    }
}