package oop.lab2;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();
            InputStream in;
            if (args.length > 0) {
                in = new FileInputStream(args[0]);
            } else {
                in = System.in;
            }
            calculator.start(in);
        }catch (Exception e){
            System.out.println("Some error");
        }
    }
}
