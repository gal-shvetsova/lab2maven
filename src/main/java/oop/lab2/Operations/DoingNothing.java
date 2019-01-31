package oop.lab2.Operations;

import oop.lab2.CalculatorContext;

public class DoingNothing implements Operation {
    @Override
    public void operate(CalculatorContext context) {
        return;
    }
}
