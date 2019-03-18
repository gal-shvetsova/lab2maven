package oop.lab2;

import oop.lab2.CalculatorExceptions.CalculatorException;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.Scanner;

public class Calculator {
    private CalculatorContext context;

    public Calculator() {
        context = new CalculatorContext();
    }

    private void calculate(String expression, OperationFactory factory) throws Exception {
        context.putToList(expression);
        Logger log = Logger.getLogger(Calculator.class);
        try {
            String operation = context.getOperation();
            factory.findOperation(operation).operate(context);
            log.info("Make " + operation);
        } catch (CalculatorException ex) {
            log.error("Catching exception in calculator. " + ex + " in " + expression);
            throw new Exception();
        }
        log.info("Successfully make calculation for " + expression);
    }

    void start(InputStream in) throws Exception {

        OperationFactory factory = OperationFactory.init("operation.properties");
        Scanner scanner = new Scanner(in);
        String expression;

        while (scanner.hasNextLine()) {
            expression = scanner.nextLine();
            calculate(expression, factory);
        }

        in.close();
    }

}
