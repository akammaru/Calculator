package com.akammaru;

/**
 * This class is the controller and only routes through to the logic in the cal model.
 */
public class CalcController {
    //create model
    private Calc calculatorModel = new Calc();

    /**
     * add number to string
     *
     * @param value input value from view
     * @return array with 3 values: current, old and error
     */
    public String[] addNumber(String value) { return calculatorModel.addNumber(value); }

    /**
     * sets the operator for the next calculation
     *
     * @param value operator for the next calculation
     * @return @return array with 3 values: current, old and error
     */
    public String[] setOpperator(char value) { return calculatorModel.storeOperator(value); }

    /**
     * clears all values
     *
     * @return array with 3 values: current, old and error
     */
    public String[] clearAll() {
        return calculatorModel.clearScreen();
    }

    /**
     * removes last character from the string
     *
     * @return array with 3 values: current, old and error
     */
    public String[] removeLastCharacter() {
        return calculatorModel.removeCharacterFromString();
    }

    /**
     * clears only the currently number, the number currently being build
     *
     * @return array with 3 values: current, old and error
     */
    public String[] clearCurrent() {
        return calculatorModel.clearActive();
    }

    /**
     * switches the number from positive to negative and reverse
     *
     * @return array with 3 values: current, old and error
     */
    public String[] reverse() {
        return calculatorModel.switchPolarity();
    }

    /**
     * returns the squre root of the current number, places the current number to stored number
     *
     * @return array with 3 values: current, old and error
     */
    public String[] squareRoot() {
        return squareRoot();
    }
}
