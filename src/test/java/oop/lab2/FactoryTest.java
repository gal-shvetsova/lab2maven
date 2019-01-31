package oop.lab2;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import oop.lab2.Operations.Add;

public class FactoryTest {
    private static int count;

    @BeforeClass
    public static void init() {
        count = OperationFactory.getInstance(null);
    }

    @Test
    public void testGetInstance() {
        Assert.assertEquals(10, count);
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
        Assert.assertTrue(Add.class == OperationFactory.findOperation("+").getClass());
    }

    @Test
    public void testFindNoOperation() {
        try {
            OperationFactory.findOperation("=").getClass();
        } catch (Exception ex) {
            assert true;
            return;
        }
        assert false;
    }


}
