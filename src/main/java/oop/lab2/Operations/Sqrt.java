package oop.lab2.Operations;

import oop.lab2.CalculatorContext;
import oop.lab2.CalculatorExceptions.CalculatorException;
import oop.lab2.CalculatorExceptions.ComputingExceptions.SqrtException;

public class Sqrt implements Operation {
    @Override
    public void operate(CalculatorContext context) throws CalculatorException {
        double arg = context.popArg();
        if (arg < 0) {
            throw new SqrtException();
        }
        context.pushArg(Math.sqrt(arg));
    }
}
