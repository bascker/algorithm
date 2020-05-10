package com.bascker.algorithm.practice.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class TestCompleteExpression {

    public void test() {
        Assert.assertEquals("((1+2)*((3-4)*(5-6)))", CompleteExpression.getInstance().complete("1+2)*3-4)*5-6)))"));
        Assert.assertEquals("((1+2)*3)", CompleteExpression.getInstance().complete("1+2)*3)"));
        Assert.assertEquals("((1+2)*(3-4))", CompleteExpression.getInstance().complete("1+2)*3-4)）"));
    }

}
