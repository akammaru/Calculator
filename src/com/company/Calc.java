package com.company;

import java.math.BigInteger;
import java.util.Arrays;

public class Calc {

    //remembered value
    private String number1;
    //current value
    private String number2;
    //error value
    private String error = null;
    //operator
    private char operator;

    private void setNumber1(String value) {
        number1 = value;
    }

    private void setNumber2(String value) {
        number2 = value;
    }

    private void setError(String value) {
        error = value;
    }

    private void setOperator(char value) {
        operator = value;
    }

    private void storeCurrent() {
        setNumber1(number2);
    }

    public String[] addNumber(String number) {
        if(number2.isEmpty()) {
            setNumber2(number);
        } else {
            number2 = number2 + number;
        }
        return setScreen();
    }

    public String[] storeOperator(char operator) {
        setOperator(operator);
        storeCurrent();
        return setScreen();
    }

    private String[] setScreen() {
        String result[] = new String[3];
        result[0] = number1;
        result[1] = number2;
        result[2] = error;

        return result;
    }

    private boolean checkData(String data) {
        BigInteger maxInt = new BigInteger(Integer.toString(Integer.MAX_VALUE));
        BigInteger minInt = new BigInteger(Integer.toString(Integer.MIN_VALUE));

        BigInteger checkSize = new BigInteger(data);
        int toLarge = checkSize.compareTo(maxInt);
        int toSmall = checkSize.compareTo(minInt);
        if (toLarge <= 0 && toSmall >= 0) {
            System.out.println("Value is correct.");
            return true;
        }
        if (toLarge > 0) {
            errorHandler(1);
        } else if (toSmall < 0) {
            errorHandler(2);
        } else {
            errorHandler(0);
        }
        System.out.println("Value is not correct");
        return false;
    }

    private boolean checkDataBoth() {
        return (checkData(number1) && checkData(number2));
    }

    private int[] bothToInt() {
        int[] intArray = new int[2];
        intArray[0] = Integer.parseInt(number1);
        intArray[1] = Integer.parseInt(number2);

        return intArray;
    }

    private int stringToInt(String value) {
        return Integer.parseInt(value);
    }

    private void bothToString(int value1, int value2) {
        number1 = Integer.toString(value1);
        number2 = Integer.toString(value2);
    }

    private void errorHandler(int errorNo) {
        String localError = null;
        switch (errorNo) {
            case 0:
                localError = "general error";
                break;
            case 1:
                localError = "Number is to large";
                break;
            case 2:
                localError = "Number is to small";
                break;
        }
        setError(localError);
    }

    /**
     * removes the last character from the string
     *
     * @return array with values to be displayed in the view
     */
    public String[] removeCharacterFromString() {
        String[] charArray = number2.split("");
        if (number2.length() <= 0) {
            this.errorHandler(0);
        } else {
            Arrays.copyOf(charArray, charArray.length - 1);
        }
        setNumber2(charArray.toString());

        return setScreen();
    }

    /**
     * clears the strings for new calculation
     *
     * @return array
     */
    public String[] clearScreen() {
        setNumber1("0");
        setNumber2(null);
        setError(null);
        return setScreen();
    }

    /**
     * clears the active string (number2)
     *
     * @return array
     */
    public String[] clearActive() {
        setNumber2(null);
        return setScreen();
    }

    /**
     * switches the polrity of the current number. (- to + and + to -)
     *
     * @return array
     */
    public String[] switchPolarity() {
        setNumber2(Integer.toString(stringToInt(number2) * -1));

        return setScreen();
    }

    /**
     * calculates the square root of the active number
     *
     * @return array
     */
    public String[] squareRoot() {
        double calculate = Double.parseDouble(number2);
        calculate = Math.sqrt(calculate);
        storeCurrent();
        setNumber2(Double.toString(calculate));


        return setScreen();
    }

    /**
     * finish the calculation, return the result values
     *
     * @return array
     */
    //todo: this is only some code storate. This is not final.
    public String[] equals() {
        checkDataBoth();
        int[] addValues = bothToInt();
        int result = addValues[0] + addValues[1];
        setNumber1(number1 + " + " + number2 + " = " + result);
        setNumber2(null);
        return setScreen();
    }
}
