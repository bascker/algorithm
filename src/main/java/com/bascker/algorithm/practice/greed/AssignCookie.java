package com.bascker.algorithm.practice.greed;

import java.util.Arrays;

/**
 * 饼干分配：假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能
 * 让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得
 * 到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * Note:
 * 1. 一个小朋友最多只能拥有一块饼干
 * 2. 假设胃口值为正
 *
 * @author bascker
 * @from leetcoded
 */
public class AssignCookie {

    public int findChildren(int[] g, int[] s) {
        // 排序：从大到小
        Arrays.sort(g);
        Arrays.sort(s);
        reverse(g);
        reverse(s);

        // 贪心分配：最大的饼干给最贪心的小盆友
        int rs = 0;
        int gi = 0;
        int si = 0;
        while (gi < g.length && si < s.length) {
            // 若最大的饼干满足最贪心的小盆友，则分配给他
            if (s[si] >= g[gi]) {
                rs ++;
                si ++;
                gi ++;
            }
            // 若不满足，则分给次贪心的小盆友
            else {
                gi --;
            }
        }

        return rs;
    }

    public void reverse(int[] arr) {
        int tmp;
        for (int min = 0, max = arr.length - 1; min < max; min ++, max --) {
            tmp = arr[min];
            arr[min] = arr[max];
            arr[max] = tmp;
        }
    }

}
