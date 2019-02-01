package oop.lab2;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FactoryLoaderTest {
    @Test
    public void testNullPath() {
        Map map = OperationFactory.readOperations(null);
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void testNullIn() {
        Map map = OperationFactory.readOperations("smthng.txt");
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void testLoader(){
        Map map = OperationFactory.readOperations("test.properties");
        Assert.assertEquals(1, map.size());
    }
}
