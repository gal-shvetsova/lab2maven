package oop.lab2.CalculatorExceptions.ArgumentsExceptions;

import oop.lab2.CalculatorExceptions.CalculatorException;

public class NoEntryLineException extends CalculatorException {

    @Override
    public String getMessage() {
        return "No entry line";
    }

    public NoEntryLineException() {
        super("No entry line");
    }
}
