package com.bascker.algorithm.data;

import com.bascker.algorithm.base.tree.TreeNode;

public final class TreeData {

    private TreeData() {}

    /**
     *       5
     *      / \
     *     4   8
     *    /   / \
     *   11  13  4
     *  / \       \
     * 7  2        1
     */
    public static TreeNode<Integer> tree1() {
        final TreeNode<Integer> root = new TreeNode<>(5);
        final TreeNode<Integer> l1Node4 = new TreeNode<>(4);
        final TreeNode<Integer> l1Node8 = new TreeNode<>(8);
        root.setLeft(l1Node4);
        root.setRight(l1Node8);

        final TreeNode<Integer> l2Node11 = new TreeNode<>(11);
        final TreeNode<Integer> l2Node13 = new TreeNode<>(13);
        final TreeNode<Integer> l2Node4 = new TreeNode<>(4);

        l1Node4.setLeft(l2Node11);

        l1Node8.setLeft(l2Node13);
        l1Node8.setRight(l2Node4);

        final TreeNode<Integer> l3Node7 = new TreeNode<>(7);
        final TreeNode<Integer> l3Node2 = new TreeNode<>(2);
        final TreeNode<Integer> l3Node1 = new TreeNode<>(1);

        l2Node11.setLeft(l3Node7);
        l2Node11.setRight(l3Node2);

        l2Node4.setRight(l3Node1);

        return root;
    }

}
