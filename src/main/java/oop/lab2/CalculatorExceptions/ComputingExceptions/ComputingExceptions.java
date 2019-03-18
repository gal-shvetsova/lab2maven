package oop.lab2.CalculatorExceptions.ComputingExceptions;

import oop.lab2.CalculatorExceptions.CalculatorException;

public class ComputingExceptions extends CalculatorException {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public ComputingExceptions(String message) {
        super(message);
        this.message = message;
    }
}
