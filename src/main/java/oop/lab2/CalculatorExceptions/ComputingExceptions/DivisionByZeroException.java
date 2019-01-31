package oop.lab2.CalculatorExceptions.ComputingExceptions;

public class DivisionByZeroException extends ComputingExceptions {
    @Override
    public String what() {
        return "Division by zero";
    }
}
