package com.bascker.algorithm.practice.tree;

import com.bascker.algorithm.base.tree.TreeNode;
import com.bascker.algorithm.common.TreeUtil;

import java.util.Objects;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和.
 *
 * in:
 *       5              sum = 22
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  / \       \
 * 7  2        1
 *
 * out: true
 *
 * @apiNote from leetcode T112
 */
public class PathSum {

    public boolean hasPathSum(final TreeNode<Integer> root, final int sum) {
        if (Objects.isNull(root)) {
            return false;
        }

        if (TreeUtil.isLeafNode(root) && root.getItem() == sum) {
            return true;
        }

        return hasPathSum(root.getLeft(), sum - root.getItem())
                || hasPathSum(root.getRight(), sum - root.getItem());
    }

}
