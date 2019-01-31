package oop.lab2.CalculatorExceptions.ArgumentsExceptions;

public class NotCommandException extends ArgumentsExceptions {
    private String command;

    public NotCommandException(String command) {
        this.command = command;
    }

    @Override
    public String what() {
        return command + " is not a command";
    }
}
