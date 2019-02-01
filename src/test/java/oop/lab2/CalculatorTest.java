package oop.lab2;

import org.junit.Test;

import java.io.FileReader;
import java.util.Scanner;

public class CalculatorTest {
    @Test
    public void testCalculator() throws Exception {
        Calculator calculator = new Calculator();

        FileReader in = new FileReader("/home/galya/ru/nsu/ccfit/shvetsova/lab2maven/src/main/resources/test.txt");
        Scanner scanner = new Scanner(in);
        String expression;

        OperationFactory.init("test.properties");


        while (scanner.hasNextLine()) {
            expression = scanner.nextLine();
            calculator.calculate(expression);
        }


    }

}
