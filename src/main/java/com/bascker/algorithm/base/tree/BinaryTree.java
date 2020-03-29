package com.bascker.algorithm.base.tree;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class BinaryTree<T> {

    @Getter
    @Setter
    protected TreeNode<T> root;

    @Getter
    @Setter
    protected int high;

    @Getter
    @Setter
    protected long nodeNum;

    public BinaryTree () {
    }

    public BinaryTree(TreeNode<T> root) {
        this.root = root;
    }

    // ---------------------------------
    // 二叉树性质
    // ---------------------------------

    /**
     * 获取二叉树的叶子节点数:
     *  非空二叉树上叶子节点数等于双分支节点数 + 1
     * @param doubleBranchNodeNum   双分支节点数
     * @return 叶子节点数
     */
    protected long getLeaftNodeNum(final int doubleBranchNodeNum) {
        if (Objects.isNull(root)) {
            return 0;
        }

        return doubleBranchNodeNum + 1;
    }

    /**
     * 获取树中空指针的个数
     *  思路: 将所有空指针节点看做叶子节点，则所有节点都是双分支节点，
     *  故而空指针节点数 = n + 1
     * @param totalNum  总节点个数
     * @return 空指针节点数
     */
    protected long getNullPointNodeNum(final int totalNum) {
        return getLeaftNodeNum(totalNum);
    }

    /**
     * 第 i 层最多有多少个节点: 2^(i - 1)
     * 思路：当第 i - 1 层全部为双分支节点时，节点数最多 ==> 此时该树也是满二叉树
     * @param level  层号
     * @return 节点数
     */
    protected long getLevelMaxNodeNum(final int level) {
        return (long) Math.pow(2, level - 1);
    }

    /**
     * 高度为 k 的二叉树最多有 2^k - 1 个节点
     * 思路: 树为满二叉树时, 节点数最多
     * @return
     */
    protected long getMaxNodeNum() {
        if (high == 0) {
            return 0;
        }

        return (long) (Math.pow(2, high) - 1);
    }

    /**
     * 一颗高度为 k 的完全二叉树(Complete Binary Tree)，第 k - 1 层的叶子节点数为 x,
     * 则该数节点个数最多有多少个？
     * @param high                  完全二叉树的高度
     * @param leafNodeNumOfUpLevel  上层的叶子节点数
     * @return 最多有多少个节点
     */
    protected long getMaxNodeNumOfCBT(final int high, final int leafNodeNumOfUpLevel) {
        final int upLevel = high - 1;
        final long totoalNum = (long) (Math.pow(2, upLevel) - 1);
        return (long) (totoalNum + (Math.pow(2, upLevel - 1) - leafNodeNumOfUpLevel) * 2);
    }

}
