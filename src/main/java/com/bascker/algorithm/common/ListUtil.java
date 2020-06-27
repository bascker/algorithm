package com.bascker.algorithm.common;

import com.bascker.algorithm.base.ListNode;

import java.util.Objects;

public class ListUtil {

    public static <T> ListNode<T> remove (final ListNode<T> head, final T element) {
        ListNode<T> pre = null;
        ListNode<T> cur = head;
        ListNode<T> result = head;
        while (Objects.nonNull(cur)) {
            // cur 是首结点
            if (Objects.isNull(pre)) {
                if (cur.getItem().equals(element)) {
                    result = cur.getNext();
                    break;
                } else {
                    pre = cur;
                }
            }
            // cur 不是首结点
            else {
                if (cur.getItem().equals(element)) {
                    pre.setNext(cur.getNext());
                    break;
                } else {
                    pre = cur;
                }
            }

            cur = cur.getNext();
        }

        return result;
    }

}
