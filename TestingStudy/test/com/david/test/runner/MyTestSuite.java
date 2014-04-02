package com.david.test.runner;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.david.test.junit3.CalculatorTest;

public class MyTestSuite extends TestCase {
    public static Test suite() {// this signature of this method can't be
                                // change, otherwise it won't OK
        TestSuite suite = new TestSuite();
        suite.addTestSuite(CalculatorTest.class);
        // suite.addTestSuite(PersonTest.class);
        // suite.addTestSuite(MyTestSuite.class); also can add test suite
        return suite;
    }
}
