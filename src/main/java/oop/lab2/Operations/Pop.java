package oop.lab2.Operations;

import oop.lab2.CalculatorContext;
import oop.lab2.CalculatorExceptions.CalculatorException;

public class Pop implements Operation{
    @Override
    public void operate(CalculatorContext context) throws CalculatorException {
        context.popArg();
    }
}
