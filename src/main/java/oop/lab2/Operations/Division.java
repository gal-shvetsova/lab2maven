package oop.lab2.Operations;

import oop.lab2.CalculatorContext;
import oop.lab2.CalculatorExceptions.CalculatorException;
import oop.lab2.CalculatorExceptions.ComputingExceptions.ComputingExceptions;
import oop.lab2.CalculatorExceptions.ComputingExceptions.DivisionByZeroException;

public class Division implements Operation {
    @Override
    public void operate(CalculatorContext context) throws CalculatorException {
        double divider = context.popArg();
        double dividend = context.popArg();
        if (divider == 0) {
            throw new DivisionByZeroException();
        }
        context.pushArg(dividend / divider);
    }
}
