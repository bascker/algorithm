package com.bascker.algorithm.practice.list;

import com.bascker.algorithm.base.ListNode;
import com.bascker.algorithm.base.Stack;
import com.bascker.algorithm.base.stack.ListStack;

import java.util.Objects;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * note: 1 ≤ m ≤ n ≤ 链表长度。
 *
 * in: 1->2->3->4->5->NULL, m = 2, n = 4
 * out: 1->4->3->2->5->NULL
 *
 * @apiNote from leetcode T92
 */
public class ReverseLinkedListII {

    public ListNode<Integer> reverseBetween(final ListNode<Integer> head, final int m, final int n) {
        ListNode<Integer> sentinel = new ListNode<>(-1, null);
        sentinel.setNext(head);

        int i = 1;
        ListNode<Integer> pm = sentinel;
        ListNode<Integer> pn = head;
        Stack<Integer> stack = new ListStack<>();
        while (Objects.nonNull(pn) && stack.size() < (n - m + 1)) {
            if (i >= m) {
                stack.push(pn.getItem());
            } else {
                pm = pm.getNext();
            }
            pn = pn.getNext();
            i ++;
        }

        ListNode<Integer> rHead = null;
        ListNode<Integer> rTail = null;
        for (int x : stack) {
            final ListNode<Integer> node = new ListNode<>(x, null);
            if (Objects.isNull(rHead)) {
                rHead = node;
            } else {
                rTail.setNext(node);
            }
            rTail = node;
        }

        pm.setNext(rHead);
        rTail.setNext(pn);

        return sentinel.getNext();
    }

}
