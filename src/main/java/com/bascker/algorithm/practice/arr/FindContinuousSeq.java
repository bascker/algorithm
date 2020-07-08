package com.bascker.algorithm.practice.arr;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * in:  target = 9
 * out: [[2,3,4],[4,5]]
 *
 * in: target = 15
 * out: [[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 解法: 滑动窗口, from 公众号“面向大象编程”
 *
 * @apiNote 剑指 Offer 57 - II
 */
public class FindContinuousSeq {

    public int[][] findContinuousSequence(int target) {
        // 窗口为 [i, j)
        int i = 1;
        int j = 1;
        int sum = 0;

        final List<int[]> results = Lists.newArrayList();
        // 因为是顺序 1~n 的，若 i = target /2 时还没有，则 i + (i + 1) 肯定 > target
        while (i <= target / 2) {
            // 窗口右边界右移
            if (sum < target) {
                sum += j;
                j ++;
            }
            // 窗口左边界右移
            else if (sum > target) {
                sum -= i;
                i ++;
            } else {
                // 找到一个和为 target 的连续正整数数列
                final int[] arr = new int[j - i];
                for (int k = i; k < j; k ++) {
                    arr[k - i] = k;
                }
                results.add(arr);

                // 左边界右移: 注意不能是重置 sum = 0, 应该交由 sum > target 中的条件去处理
                sum -= i;
                i ++;
            }
        }

        return results.toArray(new int[results.size()][]);
    }

}
