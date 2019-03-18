package oop.lab2.CalculatorExceptions.ArgumentsExceptions;

public class NotCommandException extends ArgumentsExceptions {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public NotCommandException(String command)
    {
        super(command + " is not a command");
        this.message = message;
    }
}
