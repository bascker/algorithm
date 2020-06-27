package com.bascker.algorithm.common;

import com.bascker.algorithm.base.ListNode;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestListUtil {

    @Test(dataProvider = "data")
    public void testRemove(final ListNode<Integer> head, final int val, final String expected) {
        final ListNode<Integer> rs = ListUtil.remove(head, val);
        Assert.assertEquals(ConvertUtil.list2String(rs), expected);
    }

    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        return new Object[][] {
            {ConvertUtil.string2List("123"), 2, "13"},
            {ConvertUtil.string2List("123"), 1, "23"},
            {ConvertUtil.string2List("123"), 3, "12"},
            {ConvertUtil.string2List(""), 3, ""},
            {ConvertUtil.string2List("1223"), 2, "123"},
            {ConvertUtil.string2List("12232"), 2, "1232"},
            {ConvertUtil.string2List("133212"), 2, "13312"},
            {ConvertUtil.string2List("133212"), 4, "133212"},
        };
    }

}
