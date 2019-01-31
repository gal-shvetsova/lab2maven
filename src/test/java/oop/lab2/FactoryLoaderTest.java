package oop.lab2;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class FactoryLoaderTest {
    @Test
    public void testNullPath() {
        HashMap map = FactoryLoader.makeMap(null);
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void testNullIn() {
        HashMap map = FactoryLoader.makeMap("smthng.txt");
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void testLoader(){
        HashMap map = FactoryLoader.makeMap("test.properties");
        Assert.assertEquals(1, map.size());
    }
}
