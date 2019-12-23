package com.bascker.algorithm.base;

import com.bascker.algorithm.common.ConvertUtil;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test
public class TestListBag {

    @Test
    public void test() {
        final Bag<Character> bag = new ListBag<>();
        assertTrue(bag.isEmpty());

        IntStream.range(0, 10).mapToObj(i -> (char) (i + 'a')).forEach(bag::add);
        assertEquals(bag.size(), 10);
        assertEquals(ConvertUtil.bag2String(bag), "j->i->h->g->f->e->d->c->b->a");
    }

}
