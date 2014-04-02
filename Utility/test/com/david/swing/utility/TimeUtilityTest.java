package com.david.swing.utility;

import junit.framework.Assert;

import org.junit.Test;

public class TimeUtilityTest {

    @Test
    public void testIsValidDateFormat() {
        Assert.assertEquals(true, TimeUtility.isValidDateFormat("20121231", "yyyyMMdd"));
        Assert.assertEquals(true, TimeUtility.isValidDateFormat("20120229", "yyyyMMdd"));
        Assert.assertEquals(false, TimeUtility.isValidDateFormat("20121331", "yyyyMMdd"));
    }

}
