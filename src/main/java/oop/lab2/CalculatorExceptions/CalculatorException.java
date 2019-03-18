package oop.lab2.CalculatorExceptions;

public class CalculatorException extends Exception {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public CalculatorException(String message) {
        super(message);
        this.message = message;
    }

}
