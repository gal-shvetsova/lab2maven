package oop.lab2;

import oop.lab2.CalculatorExceptions.ArgumentsExceptions.*;
import oop.lab2.CalculatorExceptions.CalculatorException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class CalculatorContext {
    private Stack<Double> argStack;
    private HashMap<String, Double> variables;
    private ArrayList<String> line;

    public CalculatorContext() {
        argStack = new Stack();
        variables = new HashMap();
        line = new ArrayList();
    }


    //work with stack

    public double popArg() throws CalculatorException{
        try {
            if (argStack.empty())
                throw new VoidStackException();
        } catch (VoidStackException ex) {
            System.out.println(ex.what());
            throw new CalculatorException();
        }
        return argStack.pop();
    }

    public double peekArg() throws CalculatorException{
        try {
            if (argStack.empty())
                throw new VoidStackException();
        } catch (VoidStackException ex) {
            System.out.println(ex.what());
            throw new CalculatorException();
        }
        return argStack.peek();
    }

    public void pushArg(double arg) {
        argStack.push(arg);
    }

    public int sizeArg() {
        return argStack.size();
    }

    //work with map

    public double getVal(String name) throws CalculatorException {
        try {
            if (variables.get(name) == null)
                throw new NoDefinitionException(name);
        } catch (NoDefinitionException ex) {
            System.out.println(ex.what());
            throw new CalculatorException();
        }
        return variables.get(name);
    }

    public void addVal(String name, double val) {
        variables.put(name, val);
    }

    //work with list

    public void putToList(String string) throws CalculatorException{
        line.clear();
        try {
            if (string == null)
                throw new NoEntryLineException();
        } catch (NoEntryLineException ex) {
            System.out.println(ex.what());
            throw new CalculatorException();
        }
        for (String word : string.split(" ")) {
            line.add(word);
        }
    }

    public String getOperation() throws CalculatorException {
        try {
            if (line.isEmpty()) {
                throw new VoidArgsException();
            }
            if (!OperationFactory.isOperation(line.get(0))) {
                throw new NotCommandException(line.get(0));
            }
        } catch (VoidArgsException ex) {
            System.out.println(ex.what());
            throw new CalculatorException();
        } catch (NotCommandException ex) {
            System.out.println(ex.what());
            throw new CalculatorException();
        }
        String command = line.get(0);
        line.remove(0);
        return command;
    }

    public String getArg() throws CalculatorException{
        try {
            if (line.isEmpty()) {
                throw new VoidArgsException();
            }
        } catch (VoidArgsException ex) {
            System.out.println(ex.what());
            throw new CalculatorException();
        }
        String arg = line.get(0);
        line.remove(0);
        return arg;
    }
}

