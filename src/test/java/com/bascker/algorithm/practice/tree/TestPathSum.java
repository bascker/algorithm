package com.bascker.algorithm.practice.tree;

import com.bascker.algorithm.base.tree.TreeNode;
import com.bascker.algorithm.data.TreeData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestPathSum {

    private PathSum instance;

    @BeforeClass
    public void beforeClass() {
        instance = new PathSum();
    }

    @Test(dataProvider = "pathSumData")
    public void test(final TreeNode<Integer> root, final int sum, final boolean expected) {
        boolean rs = instance.hasPathSum(root, sum);
        if (expected) {
            Assert.assertTrue(rs);
        } else {
            Assert.assertFalse(rs);
        }
    }

    @DataProvider(name = "pathSumData")
    private Object[][] pathSumData() {
        return new Object[][]{
            {TreeData.tree1(), 22, true}
        };
    }

}
