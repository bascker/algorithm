package com.bascker.algorithm.practice.list;

import com.bascker.algorithm.base.ListNode;
import com.bascker.algorithm.common.ConvertUtil;
import com.bascker.common.CastUtils;

import java.util.Objects;

/**
 * 给你两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * in: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * out: 7 -> 8 -> 0 -> 7
 *
 * @apiNote from leetcode 445
 */
public class AddTwoNums {

    public ListNode<Integer> addTwoNumbers(final ListNode<Integer> l1, final ListNode<Integer> l2) {
        if (Objects.isNull(l1)) {
            return l2;
        }

        if (Objects.isNull(l2)) {
            return l1;
        }

        // traversal the list
        final String s1 = ConvertUtil.list2String(l1);
        final String s2 = ConvertUtil.list2String(l2);
        final int s1Len = s1.length();
        final int s2Len = s2.length();

        /* 字符串相加 */
        final int min = Math.min(s1Len, s2Len);
        // 尾插法构造链表
        ListNode<Integer> head = null;
        int t = 0;
        for (int i = min - 1, j = 1; i >= 0; i --, j ++) {
            char c1 = s1.charAt(s1Len - j);
            char c2 = s2.charAt(s2Len - j);

            int x = CastUtils.castInt(c1) + CastUtils.castInt(c2) + t;
            t = 0;
            if (x > 9) {
                x = x - 10;
                t = 1;
            }

            if (Objects.isNull(head)) {
                head = new ListNode<>(x, null);
            } else {
                ListNode<Integer> node = new ListNode<>(x, null);
                node.setNext(head);
                head = node;
            }
        }

        // 补齐剩余部分
        final String sMax = s1Len > s2Len ? s1 : s2;
        for (int i = sMax.length() - min - 1; i >= 0; i --) {
            int x = CastUtils.castInt(sMax.charAt(i)) + t;
            t = 0;
            if (x > 9) {
                x = x - 10;
                t = 1;
            }

            ListNode<Integer> node = new ListNode<>(x, null);
            node.setNext(head);
            head = node;
        }

        // t != 0 时
        if (t != 0) {
            ListNode<Integer> node = new ListNode<>(t, null);
            node.setNext(head);
            head = node;
        }

        return head;
    }

}
