package com.bascker.algorithm.common;

import com.bascker.algorithm.base.ListStack;
import com.bascker.algorithm.base.Stack;
import com.bascker.algorithm.base.tree.TreeNode;
import com.bascker.common.Constant;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TreeUtil {

    private static final Logger LOG = LoggerFactory.getLogger(TreeUtil.class);

    private TreeUtil () {}

    // -----------------------------------------
    // 递归实现
    // -----------------------------------------

    public static <T> void preOrder(final TreeNode<T> root) {
        System.out.println(root.getItem() + Constant.BLANK);
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public static <T> void inOrder(final TreeNode<T> root) {
        inOrder(root.getLeft());
        System.out.println(root.getItem() + Constant.BLANK);
        inOrder(root.getRight());
    }

    public static <T> void postOrder(final TreeNode<T> root) {
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.println(root.getItem() + Constant.BLANK);
    }

    // -------------------------------
    // DFS(deep first search) Sample
    // -------------------------------

    /**
     * 树的最大深度
     * @param root
     * @return
     */
    public static <T> long maxDepth(final TreeNode<T> root) {
        if (Objects.isNull(root)) {
            return 0L;
        }

        final long left = maxDepth(root.getLeft());
        final long right = maxDepth(root.getRight());

        return Math.max(left, right) + 1;
    }

    // 路径总和
    private final List<Integer> list = Lists.newArrayList();
    private final List<ArrayList<Integer>> listAll = Lists.newArrayList();
    public List<ArrayList<Integer>> findPath(final TreeNode<Integer> root, int target) {
        if (Objects.isNull(root)) {
            return listAll;
        }

        list.add(root.getItem());
        target = root.getItem();
        if (target == 0 && Objects.isNull(root.getLeft()) && Objects.isNull(root.getRight())) {
            listAll.add(Lists.newArrayList(list));
        }

        findPath(root.getLeft(), target);
        findPath(root.getRight(), target);
        list.remove(list.size() - 1);

        return listAll;
    }

    // 重建二叉树
    public TreeNode<Integer> rebuildBinaryTree(int[] pre, int[] in) {
        return rebuildBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode<Integer> rebuildBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        final TreeNode<Integer> root = new TreeNode<>(pre[preStart]);
        for (int i = inStart; i < inEnd; i ++) {
            if (in[i] == pre[preStart]) {
                root.setLeft(rebuildBinaryTree(pre, preStart + 1, preStart + i - inStart,
                        in, inStart, i - 1));
                root.setRight(rebuildBinaryTree(pre, preStart + i - inStart + 1, preEnd,
                        in, i + 1, inEnd));
            }
        }

        return root;
    }

    // 二叉搜索树的最近公共祖先
    public <T> TreeNode<T> lowerCommonAncestor(TreeNode<T> root, TreeNode<T> p, TreeNode<T> q) {
        if (Objects.isNull(root) || root == p || root == q) {
            return root;
        }

        final TreeNode<T> left = lowerCommonAncestor(root.getLeft(), p, q);
        final TreeNode<T> right = lowerCommonAncestor(root.getRight(), p, q);
        if (Objects.nonNull(left) && Objects.nonNull(right)) {
            return root;
        }

        return Objects.nonNull(left) ? left : right;
    }

    // ------------------------------------------
    // 迭代实现
    // ------------------------------------------
    public static <T> List<T> preOrderTraversal(final TreeNode<T> root) {
        final List<T> list = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return list;
        }

        final Stack<TreeNode<T>> stack = new ListStack<>();
        stack.push(root);
        while (stack.isNotEmpty()) {
            final TreeNode<T> node = stack.pop();
            if (Objects.nonNull(node.getRight())) {
                stack.push(node.getRight());
            }

            if (Objects.nonNull(node.getLeft())) {
                stack.push(node.getLeft());
            }

            list.add(node.getItem());
        }

        return list;
    }

    public static <T> List<T> inOrderTraversal(final TreeNode<T> root) {
        final List<T> list = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return list;
        }

        final Stack<TreeNode<T>> stack = new ListStack<>();
        TreeNode<T> cur = root;
        while (Objects.nonNull(cur) || stack.isNotEmpty()) {
            if (Objects.nonNull(cur)) {
                stack.push(cur);
                cur = cur.getLeft();
            } else {
                cur = stack.pop();
                list.add(cur.getItem());
                cur = cur.getRight();
            }
        }

        return list;
    }

    public static <T> List<T> postOrderTravel(final TreeNode<T> root) {
        final List<T> list = inOrderTraversal(root);
        Collections.reverse(list);

        return list;
    }

}
