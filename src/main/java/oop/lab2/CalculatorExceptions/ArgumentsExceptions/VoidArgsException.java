package oop.lab2.CalculatorExceptions.ArgumentsExceptions;

public class VoidArgsException extends ArgumentsExceptions{
    @Override
    public String what() {
        return "Not enough arguments for operation";
    }
}
