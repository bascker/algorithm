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

    @DataProvider(name = "data")
    private Object[][] getDataProvider() {
        return new Object[][] {testData1(), testData2(), testData3()};
    }

    private Object[] testData1() {
        // list1: 2 -> 4 -> 3
        final ListNode<Integer> l1 = new ListNode<>(2, null);

        final ListNode<Integer> l1Node1 = new ListNode<>(4, null);
        l1.setNext(l1Node1);

        final ListNode<Integer> l1Node2 = new ListNode<>(3, null);
        l1Node1.setNext(l1Node2);

        // list2: 5 -> 6 -> 4
        final ListNode<Integer> l2 = new ListNode<>(5, null);

        final ListNode<Integer> l2Node1 = new ListNode<>(6, null);
        l2.setNext(l2Node1);

        final ListNode<Integer> l2Node2 = new ListNode<>(4, null);
        l2Node1.setNext(l2Node2);

        // expected: 8 -> 0 -> 7
        final ListNode<Integer> expected = new ListNode<>(8, null);

        final ListNode<Integer> eNode1 = new ListNode<>(0, null);
        expected.setNext(eNode1);

        final ListNode<Integer> eNode2 = new ListNode<>(7, null);
        eNode1.setNext(eNode2);

        return new Object[]{l1, l2, expected};
    }

    private Object[] testData2() {
        // list1: 7 -> 2 -> 4 -> 3
        final ListNode<Integer> l1 = new ListNode<>(7, null);

        final ListNode<Integer> l1Node1 = new ListNode<>(2, null);
        l1.setNext(l1Node1);

        final ListNode<Integer> l1Node2 = new ListNode<>(4, null);
        l1Node1.setNext(l1Node2);

        final ListNode<Integer> l1Node3 = new ListNode<>(3, null);
        l1Node2.setNext(l1Node3);

        // list2: 5 -> 6 -> 4
        final ListNode<Integer> l2 = new ListNode<>(5, null);

        final ListNode<Integer> l2Node1 = new ListNode<>(6, null);
        l2.setNext(l2Node1);

        final ListNode<Integer> l2Node2 = new ListNode<>(4, null);
        l2Node1.setNext(l2Node2);

        // expected: 7 -> 8 -> 0 -> 7
        final ListNode<Integer> expected = new ListNode<>(7, null);

        final ListNode<Integer> eNode1 = new ListNode<>(8, null);
        expected.setNext(eNode1);

        final ListNode<Integer> eNode2 = new ListNode<>(0, null);
        eNode1.setNext(eNode2);

        final ListNode<Integer> eNode3 = new ListNode<>(7, null);
        eNode2.setNext(eNode3);

        return new Object[]{l1, l2, expected};
    }

    private Object[] testData3() {
        final ListNode<Integer> l1 = new ListNode<>(5, null);
        final ListNode<Integer> l2 = new ListNode<>(5, null);

        final ListNode<Integer> expected = new ListNode<>(1, null);
        final ListNode<Integer> eNode1 = new ListNode<>(0, null);
        expected.setNext(eNode1);

        return new Object[]{l1, l2, expected};
    }

}
