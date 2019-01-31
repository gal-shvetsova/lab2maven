package oop.lab2;

import oop.lab2.CalculatorExceptions.CalculatorException;
import oop.lab2.Operations.Operation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ContextTest {
    private CalculatorContext context;

    @Before
    public void init() {
        context = new CalculatorContext();
    }

    @Test
    public void testPushArg() throws CalculatorException {
        context.pushArg(4);
        Assert.assertTrue(4 == context.peekArg());
    }

    @Test
    public void testPopArg() throws CalculatorException {
        context.pushArg(4);
        context.popArg();
        Assert.assertTrue(0 == context.sizeArg());
    }

    @Test
    public void testSizeArg() {
        context.pushArg(1);
        context.pushArg(2);
        context.pushArg(3);
        Assert.assertTrue(3 == context.sizeArg());
    }

    @Test
    public void testAddVal() throws CalculatorException {
        context.addVal("name", 1);
        Assert.assertTrue(context.getVal("name") == 1);
    }

    @Test
    public void testGetValNull() {
        try {
            context.getVal("name");
        } catch (CalculatorException ex) {
            assert true;
            return;
        }
        assert false;
    }

    @Test
    public void testPutNullToList() {
        try {
            context.putToList(null);
        } catch (CalculatorException ex) {
            assert true;
            return;
        }
        assert false;
    }

    @Test
    public void testPutToList() {
        try {
            context.putToList("something");
        } catch (CalculatorException ex) {
            assert false;
        }
        assert true;
    }

    @Test
    public void testGetOperation() throws CalculatorException, IOException {
        context.putToList("+ 5 2 3 1");
        OperationFactory.getInstance(null);
        Assert.assertEquals("+", context.getOperation());
    }

    @Test
    public void testVoidGetOperation() {
        OperationFactory.getInstance(null);
        try {
            Assert.assertEquals("+", context.getOperation());
        } catch (CalculatorException ex) {
            assert true;
            return;
        }
        assert false;
    }

    @Test
    public void testGetNoOperation() throws CalculatorException {
        context.putToList("operation");
        OperationFactory.getInstance(null);
        try {
            context.getOperation();
        } catch (CalculatorException ex) {
            assert true;
            return;
        }
        assert false;
    }

    @Test
    public void testGetArg() throws CalculatorException {
        context.putToList("5 2 3 1");
        Assert.assertEquals("5", context.getArg());
    }

    @Test
    public void testVoidGetArg() {
        try {
            context.getArg();
        } catch (CalculatorException ex) {
            assert true;
            return;
        }
        assert false;
    }
}
