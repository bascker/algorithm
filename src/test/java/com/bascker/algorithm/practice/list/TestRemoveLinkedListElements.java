package com.bascker.algorithm.practice.list;

import com.bascker.algorithm.base.ListNode;
import com.bascker.algorithm.common.ConvertUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestRemoveLinkedListElements {

    private RemoveLinkedListElements instance;

    @BeforeClass
    private void beforeClass() {
        instance = new RemoveLinkedListElements();
    }

    @Test(dataProvider = "data")
    public void test(final ListNode<Integer> head, final int val, final String expected) {
        final ListNode<Integer> result = instance.removeElements(head, val);
        Assert.assertEquals(ConvertUtil.list2String(result), expected);

        // RemoveLinkedListElements#solution
        Assert.assertEquals(ConvertUtil.list2String(instance.solution(head, val)), expected);
    }

    @DataProvider(name = "data")
    private Object[][] dataProvider() {
        return new Object[][] {
            {ConvertUtil.string2List("1263456"), 6, "12345"},
            {ConvertUtil.string2List("1223422"), 2, "134"},
            {ConvertUtil.string2List("1"), 6, "1"},
            {ConvertUtil.string2List("1"), 1, ""},
            {ConvertUtil.string2List("1111"), 1, ""},
            {ConvertUtil.string2List("2111"), 1, "2"},
            {ConvertUtil.string2List(""), 6, ""},
        };
    }

}
