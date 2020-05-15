package com.bascker.algorithm.practice.recursion;

/**
 * 外观数列是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * ["1", "11", "21", "1211", "111221"]
 * 其中，1 被读作"一个一", 即 11;
 * 11 被读作 "两个一", 即 21;
 * 21 被读作 "一个二", "一个一" , 即 1211。
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 *
 * @author bascker
 * @version v1.0
 * @from leetcode T38
 */
public class LookAndSaySequence {

    /**
     * 递归 + 双指针
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        // step1 递归: 获取当前数列前一项
        final String pre = countAndSay(n - 1);
        int len = pre.length();

        // step2 双指针: i 标识当前元素, j 标识与 i 不一样的元素
        int i = 0, j = i + 1;
        // step3 num 统计元素 i 个数
        int num = 1;
        final StringBuilder sb = new StringBuilder();
        while (j < len) {
            // 当 i 与 j 元素不一致时, 数据拼接到结果字符串, i 跳转到 j 号位, j 下移
            if (pre.charAt(i) != pre.charAt(j)) {
                sb.append(num).append(pre.charAt(i));
                i = j;
                j ++;
                // 重置 num
                num = 1;
            } else {
                j ++;
                num ++;
            }
        }

        // step4 处理特殊情况: 尾部字符相同的情况, 如 11 或 1211.
        if (j == len && pre.charAt(i) == pre.charAt(len - 1)) {
            sb.append(num).append(pre.charAt(i));
        }

        // step5 返回结果
        return sb.toString();
    }

}
