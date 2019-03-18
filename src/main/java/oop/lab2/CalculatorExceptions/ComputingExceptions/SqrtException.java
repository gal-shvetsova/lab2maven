package oop.lab2.CalculatorExceptions.ComputingExceptions;

public class SqrtException extends ComputingExceptions{

    @Override
    public String getMessage() {
        return "Negative number under the root";
    }

    public SqrtException() {
        super("Negative number under the root");
    }
}
