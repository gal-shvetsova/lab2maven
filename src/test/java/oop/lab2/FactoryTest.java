package oop.lab2;

import oop.lab2.CalculatorExceptions.ArgumentsExceptions.NotCommandException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import oop.lab2.Operations.Add;

public class FactoryTest {

    @Test
    public void testGetInstance() {
        OperationFactory factory = OperationFactory.init("operation.properties");
        Assert.assertEquals(9, factory.getMapOperationsSize());
    }

    @Test
    public void testIsOperation() {
        OperationFactory factory = OperationFactory.init("operation.properties");
        Assert.assertTrue(factory.isOperation("+"));
    }

    @Test
    public void testIsNotOperation() {
        OperationFactory factory = OperationFactory.init("operation.properties");
        Assert.assertFalse(factory.isOperation("="));
    }

    @Test
    public void testFindOperation() throws Exception {
        OperationFactory factory = OperationFactory.init("operation.properties");
        Assert.assertSame(Add.class, factory.findOperation("+").getClass());
    }

    @Test(expected = NotCommandException.class)
    public void testFindNoOperation() throws Exception {
        OperationFactory factory = OperationFactory.init("operation.properties");
        factory.findOperation("=").getClass();
    }


}
