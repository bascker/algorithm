package com.bascker.algorithm.practice.stack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


@Test
public class TestBracketMatch {

    @Test(dataProvider = "data")
    public void test(final String str, final boolean expected) {
        assertEquals(BracketMatch.getInstance().isMatch(str), expected);
    }

    @DataProvider(name = "data")
    private Object[][] dataProvider() {
        return new Object[][]{
            {"[()]{}{[()()]()}", true},
            {"()", true},
            {"{}", true},
            {"[]", true},
            {"[()]{}", true},
            {"[()]()", true},
            {"", false},
            {" ", false},
            {")", false},
            {"(", false},
            {"))", false},
            {")()", false},
            {"[()]{}{[()()](", false},
            {"[(]}", false},
            {"[(])", false},
        };
    }

}
