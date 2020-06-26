package com.bascker.algorithm.practice.list;

import com.bascker.algorithm.base.ListNode;
import com.bascker.algorithm.common.ConvertUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class TestReverse {

    private Reverse instance;

    @BeforeClass
    public void beforeClass() {
        instance = new Reverse();
    }

    @Test(dataProvider = "data")
    public <T> void test(final ListNode<T> head, final ListNode<T> expected) {
        final String sHead = ConvertUtil.list2BeautyString(instance.reverse(head));
        final String sExpected = ConvertUtil.list2BeautyString(expected);

        Assert.assertEquals(sHead, sExpected);
    }

    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        return new Object[][] {
            testData1(), testData2(), testData3()
        };
    }

    private Object[] testData1() {
        ListNode<Integer> head = null;
        ListNode<Integer> expected = null;

        return new Object[] {
            head, expected
        };
    }

    private Object[] testData2() {
        ListNode<Integer> head = new ListNode<>(1,  null);
        ListNode<Integer> expected = new ListNode<>(1, null);

        return new Object[] {
            head, expected
        };
    }

    private Object[] testData3() {
        // test data
        ListNode<Integer> head = new ListNode<>(1,  null);

        ListNode<Integer> node2 = new ListNode<>(2, null);
        head.setNext(node2);

        ListNode<Integer> node3 = new ListNode<>(3, null);
        node2.setNext(node3);

        // expected data
        ListNode<Integer> expected = new ListNode<>(3, null);

        ListNode<Integer> eNode2 = new ListNode<>(2, null);
        expected.setNext(eNode2);

        ListNode<Integer> eNode3 = new ListNode<>(1, null);
        eNode2.setNext(eNode3);


        return new Object[] {
            head, expected
        };
    }

}
