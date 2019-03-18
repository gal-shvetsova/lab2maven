package oop.lab2.CalculatorExceptions.ArgumentsExceptions;

public class NoDefinitionException extends ArgumentsExceptions {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public NoDefinitionException(String message) {
        super("No definition for " + message);
        this.message = "No definition for " + message;
    }
}
