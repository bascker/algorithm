package com.bascker.algorithm.practice.list;

import com.bascker.algorithm.base.ListNode;
import com.bascker.algorithm.common.ConvertUtil;
import com.bascker.algorithm.common.ListUtil;

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

}
