package com.bascker.algorithm.base.tree.dfs;

import com.bascker.algorithm.base.tree.TreeNode;

import java.util.Objects;

/**
 * 镜像二叉树
 * @param <T>
 * @author bascker
 * @since v1.0
 */
public class MirrorTree<T> {

    /**
     * 镜像二叉树
     * @param root
     */
    public void mirror(final TreeNode<T> root) {
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

}
