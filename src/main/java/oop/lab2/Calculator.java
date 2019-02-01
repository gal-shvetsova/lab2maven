package oop.lab2;

import oop.lab2.CalculatorExceptions.CalculatorException;
import org.apache.log4j.Logger;

public class Calculator {
    private CalculatorContext context;

    public Calculator() {
        context = new CalculatorContext();
    }

    void calculate(String expression) throws Exception {
        context.putToList(expression);
        Logger log = Logger.getLogger(Calculator.class);
        try {
            String operation = context.getOperation();
            OperationFactory.findOperation(operation).operate(context);
            log.info("Make " + operation);
        } catch (CalculatorException ex) {
            log.error("Catching exception in calculator. " + ex.what() + " in " + expression);
            System.out.println(ex.what());

            throw new Exception();
        }
        log.info("Successfully make calculation for " + expression);
    }

}
