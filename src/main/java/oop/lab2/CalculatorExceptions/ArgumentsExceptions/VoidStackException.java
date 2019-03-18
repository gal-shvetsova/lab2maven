package oop.lab2.CalculatorExceptions.ArgumentsExceptions;

public class VoidStackException extends ArgumentsExceptions {
    @Override
    public String getMessage() {
        return "No operands";
    }

    public VoidStackException() {
        super("No operands");
    }
}
