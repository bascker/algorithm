package com.bascker.algorithm.practice.stack;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class TestInfixToPostfix {

    private InfixToPostfix instance;

    @BeforeMethod
    public void before() {
        instance = new InfixToPostfix();
    }

    public void test() {
        assertEquals("23*21-/341-*+", instance.solution("2*3/(2-1)+3*(4-1)"));
    }

}
