package oop.lab2.CalculatorExceptions.ArgumentsExceptions;

public class NoDefinitionException extends ArgumentsExceptions {
    private String pseudo;

    public NoDefinitionException(String pseudo) {
        this.pseudo = pseudo;
    }

    @Override
    public String what() {
        return "No definition for " + pseudo;
    }
}
