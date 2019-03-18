package oop.lab2.CalculatorExceptions.ArgumentsExceptions;

import oop.lab2.CalculatorExceptions.CalculatorException;

public class ArgumentsExceptions extends CalculatorException {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public ArgumentsExceptions(String message){
        super(message);
        this.message = message;
    }
}
