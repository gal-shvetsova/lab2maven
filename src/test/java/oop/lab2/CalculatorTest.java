package oop.lab2;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

public class CalculatorTest {
    @Test
    public void testCalculator() throws Exception {
        Calculator calculator = new Calculator();

        FileInputStream in = new FileInputStream("/home/galya/IdeaProjects/lab2maven/src/main/resources/test.txt");
            calculator.start(in);

    }

}
