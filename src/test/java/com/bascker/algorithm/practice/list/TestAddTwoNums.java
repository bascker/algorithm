package com.bascker.algorithm.practice.list;

import com.bascker.algorithm.base.ListNode;
import com.bascker.algorithm.common.ConvertUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestAddTwoNums {

    private AddTwoNums instance;

    @BeforeClass
    public void beforeClass() {
        instance = new AddTwoNums();
    }

    @Test(dataProvider = "data")
    public void test(final ListNode<Integer> l1, final ListNode<Integer> l2, final ListNode<Integer> expected) {
        final String si = ConvertUtil.list2String(instance.addTwoNumbers(l1, l2));
        final String se = ConvertUtil.list2String(expected);
        Assert.assertEquals(si, se);
    }

    @Test(dataProvider = "data")
    public void testSolution(final ListNode<Integer> l1, final ListNode<Integer> l2, final ListNode<Integer> expected) {
        final String si = ConvertUtil.list2String(instance.solution(l1, l2));
        final String se = ConvertUtil.list2String(expected);
        Assert.assertEquals(si, se);
    }

    @DataProvider(name = "data")
    private Object[][] getDataProvider() {
        return new Object[][] {testData1(), testData2(), testData3()};
    }

    private Object[] testData1() {
        // list1: 2 -> 4 -> 3
        final ListNode<Integer> l1 = ConvertUtil.string2List("243");

        // list2: 5 -> 6 -> 4
        final ListNode<Integer> l2 = ConvertUtil.string2List("564");

        // expected: 8 -> 0 -> 7
        final ListNode<Integer> expected = ConvertUtil.string2List("807");

        return new Object[]{l1, l2, expected};
    }

    private Object[] testData2() {
        // list1: 7 -> 2 -> 4 -> 3
        final ListNode<Integer> l1 = ConvertUtil.string2List("7243");

        // list2: 5 -> 6 -> 4
        final ListNode<Integer> l2 = ConvertUtil.string2List("564");

        // expected: 7 -> 8 -> 0 -> 7
        final ListNode<Integer> expected = ConvertUtil.string2List("7807");

        return new Object[]{l1, l2, expected};
    }

    private Object[] testData3() {
        final ListNode<Integer> l1 = ConvertUtil.string2List("5");
        final ListNode<Integer> l2 = ConvertUtil.string2List("5");

        final ListNode<Integer> expected = ConvertUtil.string2List("10");

        return new Object[]{l1, l2, expected};
    }

}
