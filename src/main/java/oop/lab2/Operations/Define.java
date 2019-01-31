package oop.lab2.Operations;

import oop.lab2.CalculatorContext;
import oop.lab2.CalculatorExceptions.CalculatorException;

public class Define implements Operation {
    @Override
    public void operate(CalculatorContext context) throws CalculatorException {
        String name = context.getArg();
        Double variable = Double.parseDouble(context.getArg());
        context.addVal(name, variable);
    }
}
