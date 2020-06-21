package com.bascker.algorithm.practice.list;

import com.bascker.algorithm.base.ListNode;

import java.util.Objects;

/**
 * 原地反转单链表
 *
 * @author bascker
 * @apiNote v1.0
 */
public class Reverse {

    public <T> ListNode<T> reverse(final ListNode<T> head) {
        ListNode<T> pre = null;
        ListNode<T> cur = head;

        while (Objects.nonNull(cur)) {
            // 保存 cur 的下一个结点
            ListNode<T> cnext = cur.getNext();

            if (Objects.isNull(pre)) {
                cur.setNext(null);
            } else {
                cur.setNext(pre);
            }

            pre = cur;
            cur = cnext;
        }

        return pre;
    }

}
