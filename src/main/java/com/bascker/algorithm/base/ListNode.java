package com.bascker.algorithm.base;

import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;
import java.util.Objects;

@Getter
@Setter
public class ListNode<T> extends Node<T> implements Iterable<T> {

    private ListNode<T> next;

    public ListNode() {
    }

    public ListNode(T item, ListNode<T> next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListNodeIterator();
    }

    class ListNodeIterator implements Iterator<T> {

        private ListNode<T> cur = ListNode.this;

        @Override
        public boolean hasNext() {
            return Objects.nonNull(cur);
        }

        @Override
        public T next() {
            T item = cur.item;
            cur = cur.getNext();
            return item;
        }
    }

}
