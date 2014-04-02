package com.david.test.junit3;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.david.test.Calculator;

public class CalculatorTest extends TestCase {

    public void testDevide1() {
        Calculator cal = new Calculator();
        Throwable t = null;
        try {
            cal.devide(4, 0);
            Assert.fail();// must throw exception on last sentence
        } catch (Exception e) {
            t = e;
        }
        Assert.assertNotNull(t);// exception exist
        Assert.assertEquals(Exception.class, t.getClass());// exception type
        Assert.assertEquals("除数不能为0！", t.getMessage());// error message
    }

    public void testDevide2() {
        Calculator cal = new Calculator();
        int result = 0;
        try {
            result = cal.devide(6, 4);
        } catch (Exception e) {
            Assert.fail();// fail the case if got an exception
        }
        Assert.assertEquals(1, result);// assert the result
    }

}
