package oop.lab2;

import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String inPath;
        Calculator calculator = new Calculator();
        try {

            Properties properties = new Properties();
            InputStream inputStream = OperationFactory.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);
            inPath = properties.getProperty("inPath");
            inputStream.close();

            FileReader in = new FileReader(inPath);
            Scanner scanner = new Scanner(in);
            String expression;
            OperationFactory.init("operation.properties");

            while (scanner.hasNextLine()) {
                expression = scanner.nextLine();
                calculator.calculate(expression);
            }

            in.close();
        } catch (Exception ex) {
        }
    }
}
