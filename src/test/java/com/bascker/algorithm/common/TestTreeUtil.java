package com.bascker.algorithm.common;

import com.bascker.algorithm.base.tree.TreeNode;
import com.bascker.algorithm.data.TreeData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestTreeUtil {

    @Test(dataProvider = "treeData")
    public void testLevelOrder(final TreeNode<Integer> root, final Integer[] expected) {
        final List<Integer> list = TreeUtil.levelOrder(root);
        final Integer[] rs = list.toArray(new Integer[0]);

        Assert.assertEquals(Arrays.toString(rs), Arrays.toString(expected));
    }

    @DataProvider(name = "treeData")
    private Object[][] treeData() {
        return new Object[][] {
            {TreeData.tree1(), new Integer[]{5, 4, 8, 11, 13, 4, 7, 2, 1}}
        };
    }



}
