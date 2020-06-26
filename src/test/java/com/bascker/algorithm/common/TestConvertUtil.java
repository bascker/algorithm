package com.bascker.algorithm.common;

import com.bascker.algorithm.base.ListNode;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class TestConvertUtil {

    @Test(dataProvider = "str2ListData")
    public void testString2List(final String str, final String expected) {
        ListNode<Integer> head = ConvertUtil.string2List(str);
        Assert.assertEquals(ConvertUtil.list2BeautyString(head), expected);
    }

    @DataProvider(name = "str2ListData")
    private Object[][] str2ListData() {
        return new Object[][] {
            {"12345", "1->2->3->4->5"},
            {"1", "1"},
            {"", ""}
        };
    }

    @Test(dataProvider = "arr2ListData")
    public void testArr2List(final Integer[] arr, final String expected) {
        ListNode<Integer> head = ConvertUtil.arr2List(arr);
        Assert.assertEquals(ConvertUtil.list2BeautyString(head), expected);
    }

    @DataProvider(name = "arr2ListData")
    private Object[][] arr2ListData() {
        return new Object[][]{
            {new Integer[]{1, 2, 3, 4, 5}, "1->2->3->4->5"},
            {new Integer[]{1}, "1"},
            {new Integer[]{}, ""},
        };
    }

}
