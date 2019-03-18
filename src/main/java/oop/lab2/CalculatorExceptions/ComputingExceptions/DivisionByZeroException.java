package oop.lab2.CalculatorExceptions.ComputingExceptions;

public class DivisionByZeroException extends ComputingExceptions {

    @Override
    public String getMessage() {
        return "Division by zero";
    }

    public DivisionByZeroException(){
        super("Division by zero");
    }
}
