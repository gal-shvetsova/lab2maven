package oop.lab2;

import oop.lab2.CalculatorExceptions.ArgumentsExceptions.NotCommandException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import oop.lab2.Operations.Add;

public class FactoryTest {

    @BeforeClass
    public static void init() {
        OperationFactory.init(null);
    }

    @Test
    public void testGetInstance() {
        Assert.assertEquals(10, OperationFactory.getMapOperationsSize());
    }

    @Test
    public void testIsOperation() {
        Assert.assertTrue(OperationFactory.isOperation("+"));
    }

    @Test
    public void testIsNotOperation() {
        Assert.assertFalse(OperationFactory.isOperation("="));
    }

    @Test
    public void testFindOperation() throws Exception {
        Assert.assertSame(Add.class, OperationFactory.findOperation("+").getClass());
    }

    @Test(expected = NotCommandException.class)
    public void testFindNoOperation() throws Exception {
            OperationFactory.findOperation("=").getClass();
    }


}
