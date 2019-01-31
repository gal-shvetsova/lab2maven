package oop.lab2.CalculatorExceptions.ArgumentsExceptions;

import oop.lab2.CalculatorExceptions.CalculatorException;

public class NoEntryLineException extends CalculatorException {
    @Override
    public String what() {
        return "No entry line";
    }
}
