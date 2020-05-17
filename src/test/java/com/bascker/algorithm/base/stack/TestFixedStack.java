package com.bascker.algorithm.base.stack;

import com.bascker.algorithm.base.Stack;
import com.bascker.algorithm.base.stack.FixedStack;
import com.bascker.algorithm.common.ConvertUtil;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.expectThrows;

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

    public void testIsFull() {
        final Stack<Integer> stack = new FixedStack<>(2);
        IntStream.range(1, 3).boxed().forEach(stack::push);
        assertEquals(stack.size(), 2);
        assertTrue(((FixedStack<Integer>) stack).isFull());
        expectThrows(ArrayIndexOutOfBoundsException.class, () -> {stack.push(3);});
    }

}
