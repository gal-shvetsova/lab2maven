package oop.lab2;

import org.junit.Test;

import java.io.FileReader;
import java.util.Scanner;

public class CalculatorTest {
    @Test
    public void testCalculator(){
        Calculator calculator = new Calculator();

        try {
            FileReader in = new FileReader("/home/galya/ru/nsu/ccfit/shvetsova/lab2maven/src/main/resources/test.txt");
            Scanner scanner = new Scanner(in);
            String expression;

            OperationFactory.getInstance("test.properties");


            while (scanner.hasNextLine()) {
                expression = scanner.nextLine();
                calculator.calculate(expression);
            }

        } catch (Exception ex) {
            System.out.println(ex);
            assert false;
            return;
        }
        assert true;
        return;
    }

}
