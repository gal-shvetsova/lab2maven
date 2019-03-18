package oop.lab2;

import oop.lab2.CalculatorExceptions.ArgumentsExceptions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class CalculatorContext {
    private Stack<Double> argStack;
    private HashMap<String, Double> variables;
    private ArrayList<String> line;

    public CalculatorContext() {
        argStack = new Stack<>();
        variables = new HashMap<>();
        line = new ArrayList<>();
    }

    //work with stack

    public double popArg() throws VoidStackException{
        try {
            if (argStack.empty())
                throw new VoidStackException();
        } catch (VoidStackException ex) {
            System.out.println(ex.getMessage());

            throw new VoidStackException();
        }
        return argStack.pop();
    }

    public double peekArg() throws VoidStackException{
        try {
            if (argStack.empty())
                throw new VoidStackException();
        } catch (VoidStackException ex) {
            System.out.println(ex.getMessage());

            throw new VoidStackException();
        }
        return argStack.peek();
    }

    public void pushArg(double arg) {
        argStack.push(arg);
    }

    int sizeArg() {
        return argStack.size();
    }

    //work with map

    public double getVal(String name) throws NoDefinitionException {
        try {
            if (variables.get(name) == null)
                throw new NoDefinitionException(name);
        } catch (NoDefinitionException ex) {
            System.out.println(ex.getMessage());

            throw new NoDefinitionException("");
        }
        return variables.get(name);
    }

    public void addVal(String name, double val) {
        variables.put(name, val);
    }

    //work with list

    void putToList(String string) throws NoEntryLineException{
        line.clear();
        try {
            if (string == null)
                throw new NoEntryLineException();
        } catch (NoEntryLineException ex) {
            System.out.println(ex.getMessage());

            throw new NoEntryLineException();
        }
        Collections.addAll(line, string.split(" "));
    }

    public String getOperation() throws NotCommandException, VoidArgsException {
        try {
            if (line.isEmpty()) {
                throw new VoidArgsException();
            }
            if (!OperationFactory.isOperation(line.get(0))) {
                throw new NotCommandException(line.get(0));
            }
        } catch (VoidArgsException ex) {
            System.out.println(ex.getMessage());

            throw new VoidArgsException();
        } catch (NotCommandException ex) {
            System.out.println(ex.getMessage());

            throw new NotCommandException("");
        }
        String command = line.get(0);
        line.remove(0);
        return command;
    }

    public String getArg() throws VoidArgsException{
        try {
            if (line.isEmpty()) {
                throw new VoidArgsException();
            }
        } catch (VoidArgsException ex) {
            System.out.println(ex.getMessage());

            throw new VoidArgsException();
        }
        String arg = line.get(0);
        line.remove(0);
        return arg;
    }
}

