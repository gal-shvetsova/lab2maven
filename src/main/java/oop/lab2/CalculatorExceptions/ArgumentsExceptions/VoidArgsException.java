package oop.lab2.CalculatorExceptions.ArgumentsExceptions;

public class VoidArgsException extends ArgumentsExceptions{
    @Override
    public String getMessage() {
        return "Not enough arguments for operation";
    }

    public VoidArgsException() {
        super("Not enough arguments for operation");
    }
}
