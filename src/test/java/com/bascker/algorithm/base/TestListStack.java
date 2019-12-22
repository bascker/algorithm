package com.bascker.algorithm.base;

import com.bascker.algorithm.common.ConvertUtil;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test
public class TestListStack {

    public void test() {
        final Stack<Character> stack = new ListStack<>();
        assertTrue(stack.isEmpty());

        IntStream.range(0, 10).mapToObj(i -> (char) (i + 'a')).forEach(stack::push);
        assertEquals(stack.size(), 10);
        assertEquals(ConvertUtil.stack2Sting(stack), "j->i->h->g->f->e->d->c->b->a");
    }

}
