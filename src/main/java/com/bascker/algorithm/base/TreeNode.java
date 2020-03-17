package com.bascker.algorithm.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TreeNode<T> {

    private T val;

    private TreeNode<T> left;

    private TreeNode<T> right;

    public TreeNode() {
    }

    public TreeNode(T value) {
        this.val = value;
    }

    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
