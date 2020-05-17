package com.bascker.algorithm.base.queue;

import com.bascker.algorithm.base.Queue;
import com.bascker.algorithm.base.queue.ListQueue;
import com.bascker.algorithm.common.ConvertUtil;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;

@Test
public class TestListQueue {

    public void test() {
        final Queue<Integer> queue = new ListQueue<>();
        IntStream.range(0, 10).boxed().forEach(queue::enqueue);
        assertEquals(ConvertUtil.queue2String(queue), "0->1->2->3->4->5->6->7->8->9");

        assertEquals(queue.dequeue().intValue(), 0);
        assertEquals(queue.size(), 9);

        queue.enqueue(10);
        assertEquals(ConvertUtil.queue2String(queue), "1->2->3->4->5->6->7->8->9->10");
    }

}
