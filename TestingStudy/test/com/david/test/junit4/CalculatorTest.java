package com.david.test.junit4;

import junit.framework.Assert;

import org.junit.Test;

import com.david.test.Calculator;

public class CalculatorTest {// No need extends TestCase

    @Test(expected = Exception.class)
    public void devide1() throws Exception {
        new Calculator().devide(4, 0);
    }

    @Test
    public void testDevide2() {// no need to name the method name start with
                               // “test”
        Calculator cal = new Calculator();
        int result = 0;
        try {
            result = cal.devide(6, 4);
        } catch (Exception e) {
            Assert.fail();
        }
        Assert.assertEquals(1, result);
    }

}
