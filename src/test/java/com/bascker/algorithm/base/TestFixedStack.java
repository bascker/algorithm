package com.bascker.algorithm.base;

import com.bascker.algorithm.common.ConvertUtil;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test
public class TestFixedStack {

    public void test() {
        final Stack<Integer> stack = new FixedStack<>(10);
        assertTrue(stack.isEmpty());

        IntStream.range(1, 11).boxed().forEach(stack::push);
        assertEquals(stack.size(), 10);
        assertEquals(ConvertUtil.stack2Sting(stack), "10->9->8->7->6->5->4->3->2->1");

        for (Integer num : stack)
        {
            stack.pop();
        }
        assertEquals(stack.size(), 0);
    }

}
