package oop.lab2;

import oop.lab2.CalculatorExceptions.CalculatorException;
import oop.lab2.CalculatorExceptions.ComputingExceptions.DivisionByZeroException;
import oop.lab2.CalculatorExceptions.ComputingExceptions.SqrtException;
import oop.lab2.Operations.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OperationsTest {
    private CalculatorContext context;

    @Before
    public void init() {
        context = new CalculatorContext();
    }

    @Test
    public void testAdd() throws CalculatorException{
        Add add = new Add();
        context.pushArg(1);
        context.pushArg(1);
        add.operate(context);
        Assert.assertTrue(2.0 == context.peekArg());
        context.popArg();
    }

    @Test
    public void testSub() throws CalculatorException {
        Subtraction sub = new Subtraction();
        context.pushArg(4);
        context.pushArg(2);
        sub.operate(context);
        Assert.assertTrue(2.0 == context.peekArg());
        context.popArg();
    }

    @Test
    public void testMul() throws CalculatorException {
        Multiplication mul = new Multiplication();
        context.pushArg(4);
        context.pushArg(2);
        mul.operate(context);
        Assert.assertTrue(8.0 == context.peekArg());
        context.popArg();
    }

    @Test
    public void testPop() throws CalculatorException{
        Pop pop = new Pop();
        context.pushArg(2);
        pop.operate(context);
        Assert.assertEquals(0, context.sizeArg());
    }

    @Test
    public void testPush() throws CalculatorException{
        Push push = new Push();
        context.putToList("1");
        push.operate(context);
        Assert.assertTrue(1 == context.peekArg());
        context.popArg();
    }

    @Test
    public void testDefine() throws CalculatorException{
        Define define = new Define();
        context.putToList("a 4");
        define.operate(context);
        Assert.assertTrue(4 == context.getVal("a"));
    }

    @Test
    public void testDivision() throws CalculatorException{
        Division division = new Division();
        context.pushArg(4);
        context.pushArg(2);
        try {
            division.operate(context);
        } catch (CalculatorException ex) {
            assert false;
        }
        Assert.assertTrue(2 == context.peekArg());
        context.popArg();
    }

    @Test
    public void testDivisionByZero() throws CalculatorException{
        Division division = new Division();
        context.pushArg(4);
        context.pushArg(0);
        try {
            division.operate(context);
        } catch (DivisionByZeroException ex) {
            assert true;
            return;
        }
        assert false;
        context.popArg();
    }

    @Test
    public void testSqrt() throws CalculatorException{
        Sqrt sqrt = new Sqrt();
        context.pushArg(4);
        try {
            sqrt.operate(context);
        } catch (SqrtException ex) {
            assert false;
        }
        Assert.assertTrue(2.0 == context.peekArg());
        context.popArg();
    }

    @Test
    public void testSqrtException() throws CalculatorException {
        Sqrt sqrt = new Sqrt();
        context.pushArg(-4);
        try {
            sqrt.operate(context);
        } catch (SqrtException ex) {
            assert true;
            return;
        }
        assert false;
        context.popArg();
    }

}
