package oop.lab2;

import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            FileReader in = new FileReader("/home/galya/ru/nsu/ccfit/shvetsova/lab2maven/src/main/resources/in.txt");
            Scanner scanner = new Scanner(in);
            String expression;
            OperationFactory.getInstance("config.properties");

            while (scanner.hasNextLine()) {
                expression = scanner.nextLine();
                calculator.calculate(expression);
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return;
        }
    }
}
