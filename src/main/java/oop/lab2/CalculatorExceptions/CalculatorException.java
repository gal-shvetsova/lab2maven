package oop.lab2.CalculatorExceptions;

public class CalculatorException extends Exception {
    public String what() {
        return "Impossible to calculate";
    }
}
