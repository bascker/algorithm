package com.bascker.algorithm.base.tree.dfs;

import com.bascker.algorithm.base.tree.TreeNode;

import java.util.Objects;

/**
 * 对称二叉树
 *
 * @param <T>
 * @author bascker
 * @since v1.0
 */
public class SymmetricalTree<T> {

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

}