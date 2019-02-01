package oop.lab2.Operations;

import oop.lab2.CalculatorContext;
import oop.lab2.CalculatorExceptions.CalculatorException;

public class Push implements Operation {
    @Override
    public void operate(CalculatorContext context) throws CalculatorException {
            String arg = context.getArg();
            if (!isName(arg)) {
                context.pushArg(Double.parseDouble(arg));
            }
            else {
                context.pushArg(context.getVal(arg));
            }
    }

    private boolean isName(String string) throws CalculatorException{
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isLetter(string.charAt(i)))
                return false;
        }
        return true;
    }
}
