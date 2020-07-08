package com.bascker.algorithm.practice.arr;

import com.bascker.algorithm.common.ConvertUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Test
public class TestFindContinuousSeq {

    private FindContinuousSeq instance;

    @BeforeClass
    private void beforeClass() {
        instance = new FindContinuousSeq();
    }

    @Test(dataProvider = "data")
    public void test(final int target, final int[][] expected) {
        final int[][] rs = instance.findContinuousSequence(target);
        Assert.assertEquals(ConvertUtil.arr2String(rs), ConvertUtil.arr2String(expected));
    }

    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        return new Object[][]{
            {9, new int[][]{{2,3,4}, {4,5}}},
            {15, new int[][]{{1,2,3,4,5}, {4,5,6}, {7,8}}}
        };
    }

}
