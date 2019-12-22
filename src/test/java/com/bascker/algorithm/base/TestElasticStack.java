package com.bascker.algorithm.base;

import com.bascker.algorithm.common.ConvertUtil;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;

@Test
public class TestElasticStack {

    public void test() {
        final ElasticStack<Integer> stack = new ElasticStack<>(10);
        assertEquals(stack.size(), 0);

        IntStream.range(1, 5).boxed().forEach(stack::push);
        assertEquals(stack.size(), 4);
        assertEquals(ConvertUtil.stack2Sting(stack), "4->3->2->1");

        stack.pop();
        stack.pop();
        assertEquals(stack.getCapacity(), 5);
    }

}
