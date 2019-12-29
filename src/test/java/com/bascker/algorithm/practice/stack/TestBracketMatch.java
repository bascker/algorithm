package com.bascker.algorithm.practice.stack;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Test
public class TestBracketMatch {

    public void test() {
        assertTrue(BracketMatch.getInstance().isMatch("[()]{}{[()()]()}"));
        assertTrue(BracketMatch.getInstance().isMatch("()"));
        assertTrue(BracketMatch.getInstance().isMatch("{}"));
        assertTrue(BracketMatch.getInstance().isMatch("[]"));
        assertTrue(BracketMatch.getInstance().isMatch("[()]{}"));
        assertTrue(BracketMatch.getInstance().isMatch("[()]()"));
        assertFalse(BracketMatch.getInstance().isMatch(""));
        assertFalse(BracketMatch.getInstance().isMatch(" "));
        assertFalse(BracketMatch.getInstance().isMatch(")"));
        assertFalse(BracketMatch.getInstance().isMatch("("));
        assertFalse(BracketMatch.getInstance().isMatch("))"));
        assertFalse(BracketMatch.getInstance().isMatch(")()"));
        assertFalse(BracketMatch.getInstance().isMatch("[()]{}{[()()]("));
        assertFalse(BracketMatch.getInstance().isMatch("[(]}"));
        assertFalse(BracketMatch.getInstance().isMatch("[(])"));

    }

}
