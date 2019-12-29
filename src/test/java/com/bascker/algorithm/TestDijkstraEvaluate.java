package com.bascker.algorithm;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class TestDijkstraEvaluate {

    public void test() {
        assertEquals(DijkstraEvaluate.getInstance().evaluate("(1 + ((2 + 3 ) * (4 * 5)))"), "101.0");
        assertEquals(DijkstraEvaluate.getInstance().evaluate("(1 + 0)"), "1.0");
    }

}
