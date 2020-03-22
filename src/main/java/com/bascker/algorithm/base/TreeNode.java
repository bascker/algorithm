package com.bascker.algorithm.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TreeNode<T> extends Node<T> {

    private TreeNode<T> left;

    private TreeNode<T> right;

    public TreeNode() {
    }

    public TreeNode(T item) {
        this.item = item;
    }

    public TreeNode(T item, TreeNode<T> left, TreeNode<T> right) {
        this.item = item;
        this.left = left;
        this.right = right;
    }

}
