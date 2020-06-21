package com.bascker.algorithm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class TestDijkstraEvaluate {

    @Test(dataProvider = "data")
    public void test(final String str, final String expected) {
        assertEquals(expected, DijkstraEvaluate.getInstance().evaluate(str));
    }

    @DataProvider(name = "data")
    private Object[][] dataProvider() {
        return new Object[][]{
            {"(1 + ((2 + 3 ) * (4 * 5)))", "101.0"},
            {"(1 + 0)", "1.0"},
        };
    }

}
