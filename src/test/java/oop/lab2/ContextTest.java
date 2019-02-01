package oop.lab2;

import oop.lab2.CalculatorExceptions.ArgumentsExceptions.NoDefinitionException;
import oop.lab2.CalculatorExceptions.ArgumentsExceptions.NoEntryLineException;
import oop.lab2.CalculatorExceptions.ArgumentsExceptions.NotCommandException;
import oop.lab2.CalculatorExceptions.ArgumentsExceptions.VoidArgsException;
import oop.lab2.CalculatorExceptions.CalculatorException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContextTest {
    private CalculatorContext context;

    @Before
    public void init() {
        context = new CalculatorContext();
    }

    @Test
    public void testPushArg() throws CalculatorException {
        context.pushArg(4);
        Assert.assertEquals(4, context.peekArg(), 0.1);
    }

    @Test
    public void testPopArg() throws CalculatorException {
        context.pushArg(4);
        context.popArg();
        Assert.assertEquals(0, context.sizeArg());
    }

    @Test
    public void testSizeArg() {
        context.pushArg(1);
        context.pushArg(2);
        context.pushArg(3);
        Assert.assertEquals(3, context.sizeArg());
    }

    @Test
    public void testAddVal() throws CalculatorException {
        context.addVal("name", 1);
        Assert.assertEquals(1, context.getVal("name"), 0.1);
    }

    @Test(expected = NoDefinitionException.class)
    public void testGetValNull() throws CalculatorException {
        context.getVal("name");
    }

    @Test(expected = NoEntryLineException.class)
    public void testPutNullToList() throws CalculatorException {
        context.putToList(null);
    }

    @Test
    public void testPutToList() throws CalculatorException {
        context.putToList("something");
    }

    @Test
    public void testGetOperation() throws CalculatorException {
        context.putToList("+ 5 2 3 1");
        OperationFactory.init(null);
        Assert.assertEquals("+", context.getOperation());
    }

    @Test(expected = VoidArgsException.class)
    public void testVoidGetOperation() throws CalculatorException {
        Assert.assertEquals("+", context.getOperation());
    }

    @Test(expected = NotCommandException.class)
    public void testGetNoOperation() throws CalculatorException {
        context.putToList("operation");
        OperationFactory.init(null);
        context.getOperation();
    }

    @Test
    public void testGetArg() throws CalculatorException {
        context.putToList("5 2 3 1");
        Assert.assertEquals("5", context.getArg());
    }

    @Test(expected = VoidArgsException.class)
    public void testVoidGetArg() throws CalculatorException {
        context.getArg();
    }
}
