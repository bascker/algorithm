package com.bascker.algorithm.practice.recursion;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class TestLookAndSaySequence {

    private LookAndSaySequence lass;

    @BeforeMethod
    public void before() {
        lass = new LookAndSaySequence();
    }

    public void test() {
        Assert.assertEquals(lass.countAndSay(1), "1");
        Assert.assertEquals(lass.countAndSay(2), "11");
        Assert.assertEquals(lass.countAndSay(3), "21");
        Assert.assertEquals(lass.countAndSay(4), "1211");
        Assert.assertEquals(lass.countAndSay(5), "111221");
        Assert.assertEquals(lass.countAndSay(6), "312211");
    }

}
