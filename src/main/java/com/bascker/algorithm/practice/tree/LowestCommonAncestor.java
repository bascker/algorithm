package com.bascker.algorithm.practice.tree;

import com.bascker.algorithm.base.tree.TreeNode;

import java.util.Objects;

/**
 * 二叉树的最近公共祖先: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 最近公共祖先：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * Note:
 * 1. 所有节点的值都是唯一的
 * 2. p、q 为不同节点且均存在于给定的二叉树中
 *
 * @author bascker
 * @from leetcode T236
 */
public class LowestCommonAncestor {

    /**
     * DFS 的使用
     */
    public TreeNode<Integer> lca(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (Objects.isNull(root) || root == p || root == q) {
            return null;
        }

        final TreeNode<Integer> left = lca(root.getLeft(), p, q);
        final TreeNode<Integer> right = lca(root.getRight(), p, q);

        if (Objects.nonNull(left) && Objects.nonNull(right)) {
            return root;
        } else if (Objects.nonNull(left)) {
            return left;
        } else if (Objects.nonNull(right)) {
            return right;
        }

        return null;
    }

}
