package oop.lab2.Operations;


import oop.lab2.CalculatorContext;

public interface Operation {
    void operate(CalculatorContext context) throws Exception;
}
