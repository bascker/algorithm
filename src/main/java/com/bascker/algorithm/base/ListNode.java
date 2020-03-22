package com.bascker.algorithm.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListNode<T> extends Node<T> {

    private ListNode<T> next;

    public ListNode() {
    }

    public ListNode(T item, ListNode<T> next) {
        this.item = item;
        this.next = next;
    }

}
