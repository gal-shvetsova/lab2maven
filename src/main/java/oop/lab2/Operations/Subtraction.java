package oop.lab2.Operations;

import oop.lab2.CalculatorContext;
import oop.lab2.CalculatorExceptions.CalculatorException;

public class Subtraction implements Operation {
    @Override
    public void operate (CalculatorContext context) throws CalculatorException {
        context.pushArg(-context.popArg() + context.popArg());
    }
}
