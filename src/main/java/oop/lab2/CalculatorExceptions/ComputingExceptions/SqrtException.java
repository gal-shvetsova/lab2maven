package oop.lab2.CalculatorExceptions.ComputingExceptions;

public class SqrtException extends ComputingExceptions{
    @Override
    public String what() {
        return "Negative number under the root";
    }
}
