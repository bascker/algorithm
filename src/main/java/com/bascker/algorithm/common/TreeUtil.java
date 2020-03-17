package com.bascker.algorithm.common;

import com.bascker.algorithm.base.ListStack;
import com.bascker.algorithm.base.Stack;
import com.bascker.algorithm.base.TreeNode;
import com.bascker.common.Constant;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    // -------------------------------
    // DFS Sample
    // -------------------------------

    /**
     * 镜像二叉树
     * @param root
     */
    public static <T> void mirror(final TreeNode<T> root) {
        if (Objects.nonNull(root)) {
            if (Objects.nonNull(root.getLeft()) || Objects.nonNull(root.getRight())) {
                final TreeNode<T> tmp = root.getLeft();
                root.setLeft(tmp.getRight());
                root.setRight(tmp);
            }

            mirror(root.getLeft());
            mirror(root.getRight());
        }
    }

    /**
     * 判断二叉树是否对称
     * @param root
     * @param <T>
     * @return
     */
    public static <T> boolean isSymmetrical(final TreeNode<T> root) {
        if (Objects.isNull(root)) {
            return true;
        }

        return doSymmetrical(root.getLeft(), root.getRight());
    }

    private static <T> boolean doSymmetrical(final TreeNode<T> root1, final TreeNode<T> root2) {
        if (Objects.isNull(root1) && Objects.isNull(root2)) {
            return true;
        }

        if (Objects.isNull(root1) || Objects.isNull(root2)) {
            return false;
        }

        if (!Objects.equals(root1, root2)) {
            return false;
        }

        return doSymmetrical(root1.getLeft(), root2.getLeft())
                && doSymmetrical(root1.getRight(), root2.getRight());
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
