package com.bascker.algorithm.practice.list;

import com.bascker.algorithm.base.ListNode;

import java.util.Objects;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * in: 1->2->6->3->4->5->6, val = 6
 * out: 1->2->3->4->5
 *
 * @apiNote from leetcode 203
 */
public class RemoveLinkedListElements {

    public ListNode<Integer> removeElements(final ListNode<Integer> head, final int val) {
        ListNode<Integer> pre = null;
        ListNode<Integer> cur = head;
        ListNode<Integer> result = head;
        while (Objects.nonNull(cur)) {
            // cur 是首结点
            if (Objects.isNull(pre)) {
                if (cur.getItem().equals(val)) {
                    result = cur.getNext();
                } else {
                    pre = cur;
                }
            }
            // cur 不是首结点
            else {
                if (cur.getItem().equals(val)) {
                    pre.setNext(cur.getNext());
                } else {
                    pre = cur;
                }
            }

            cur = cur.getNext();
        }

        return result;
    }

    /**
     * 哨兵解法: 对比 {@link #removeElements(ListNode, int)}, 代码更精简, 本质区别只在于 line50~51
     *
     * 哨兵节点广泛应用于树和链表中，如伪头、伪尾、标记等
     * 通常不保存任何数据，其主要目的是使链表标准化，如使链表永不为空、永不无头、简化插入和删除。
     * @implNote from leetcode
     */
    public ListNode<Integer> solution(final ListNode<Integer> head, final int val) {
        // 初始化哨兵结点, 下一跳为链表头
        ListNode<Integer> sentinel = new ListNode<>(-1, null);
        sentinel.setNext(head);

        ListNode<Integer> pre = sentinel;
        ListNode<Integer> cur = head;

        while (Objects.nonNull(cur)) {
            if (cur.getItem().equals(val)) {
                pre.setNext(cur.getNext());
            } else {
                pre = cur;
            }

            cur = cur.getNext();
        }

        return sentinel.getNext();
    }

}
