package com.bascker.algorithm.practice.stack;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class TestCompleteExpression {

    @Test(dataProvider = "data")
    public void test(final String str, final String expected) {
        Assert.assertEquals(expected, CompleteExpression.getInstance().complete(str));
    }

    @DataProvider(name = "data")
    private Object[][] dataProvider() {
        return new Object[][] {
            {"1+2)*3-4)*5-6)))", "((1+2)*((3-4)*(5-6)))"},
            {"1+2)*3)", "((1+2)*3)"},
            {"1+2)*3-4))", "((1+2)*(3-4))"},
        };
    }

}
