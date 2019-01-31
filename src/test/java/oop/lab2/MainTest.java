package oop.lab2;

import oop.lab2.Operations.Add;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class MainTest{
    @Before
    @Test
    public void test(){
        System.out.println("test");
        Assert.assertEquals(true, true);
    }

    @Test
    public void test2(){
        System.out.println("test2");
        Assert.assertEquals(true, false);

    }

    @Test
    public void addTest() throws Exception{
        Add add = new Add();
        CalculatorContext context = mock(CalculatorContext.class);
        when(context.popArg()).thenReturn(1.0);
        add.operate(context);
        System.out.println(context.peekArg());
    }


}
