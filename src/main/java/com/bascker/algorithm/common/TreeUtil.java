package com.bascker.algorithm.common;

import com.bascker.algorithm.base.ListStack;
import com.bascker.algorithm.base.Stack;
import com.bascker.algorithm.base.TreeNode;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TreeUtil {

    private TreeUtil () {}

    // -----------------------------------------
    // 递归实现
    // -----------------------------------------

    public static <T> void preOrder(final TreeNode<T> root) {
        System.out.println(root.getVal() + Constant.BLANK);
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public static <T> void inOrder(final TreeNode<T> root) {
        inOrder(root.getLeft());
        System.out.println(root.getVal() + Constant.BLANK);
        inOrder(root.getRight());
    }

    public static <T> void postOrder(final TreeNode<T> root) {
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.println(root.getVal() + Constant.BLANK);
    }

    // ------------------------------------------
    // 迭代实现
    // ------------------------------------------
    public static <T> List<T> preOrderTraverl(final TreeNode<T> root) {
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

            list.add(node.getVal());
        }

        return list;
    }

    public static <T> List<T> inOrderTraverl(final TreeNode<T> root) {
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
                list.add(cur.getVal());
                cur = cur.getRight();
            }
        }

        return list;
    }

    public static <T> List<T> postOrderTravel(final TreeNode<T> root) {
        final List<T> list = inOrderTraverl(root);
        Collections.reverse(list);

        return list;
    }

}
