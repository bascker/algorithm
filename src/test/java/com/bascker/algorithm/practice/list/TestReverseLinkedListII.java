package com.bascker.algorithm.practice.list;

import com.bascker.algorithm.base.ListNode;
import com.bascker.algorithm.common.ConvertUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestReverseLinkedListII {

    private ReverseLinkedListII instance;

    @BeforeClass
    private void beforeClass() {
        instance = new ReverseLinkedListII();
    }

    @Test(dataProvider = "data")
    public void test(final ListNode<Integer> head, final int m, final int n, final String expected) {
        final ListNode<Integer> rHead = instance.reverseBetween(head, m, n);
        Assert.assertEquals(ConvertUtil.list2String(rHead), expected);
    }

    @DataProvider(name = "data")
    private Object[][] dataProvider() {
        return new Object[][]{
            {ConvertUtil.string2List("12345"), 2, 4, "14325"},
            {ConvertUtil.string2List("12345"), 1, 4, "43215"},
            {ConvertUtil.string2List("12345"), 1, 5, "54321"},
            {ConvertUtil.arr2List(new Integer[]{3, 1, 3, 4, 1, 4, -1}), 3, 7, "31-14143"},
        };
    }

}
