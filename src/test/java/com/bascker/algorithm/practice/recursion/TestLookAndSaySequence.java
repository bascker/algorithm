package com.bascker.algorithm.practice.recursion;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class TestLookAndSaySequence {

    private LookAndSaySequence lass;

    @BeforeMethod
    public void before() {
        lass = new LookAndSaySequence();
    }

    @Test(dataProvider = "data")
    public void test(final int n, final String expected ) {
        Assert.assertEquals(lass.countAndSay(n), expected);
    }

    @DataProvider(name = "data")
    private Object[][] dataProvider() {
        return new Object[][]{
            {1, "1"},
            {2, "11"},
            {3, "21"},
            {4, "1211"},
            {5, "111221"},
            {6, "312211"}
        };
    }

}
