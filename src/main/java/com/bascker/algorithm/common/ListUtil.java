package com.bascker.algorithm.common;

import com.bascker.algorithm.base.ListNode;

import java.util.Objects;

public class ListUtil {

    public static <T> ListNode<T> remove (final ListNode<T> head, final T element) {
        ListNode<T> sentinel = new ListNode<>();
        sentinel.setNext(head);

        ListNode<T> pre = sentinel;
        ListNode<T> cur = head;
        while (Objects.nonNull(cur)) {
            if (cur.getItem().equals(element)) {
                pre.setNext(cur.getNext());
                break;
            } else {
                pre = cur;
            }

            cur = cur.getNext();
        }

        return sentinel.getNext();
    }

}
