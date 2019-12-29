package com.bascker.algorithm.base;

import java.util.Iterator;
import java.util.Objects;

/**
 * 背包的链表实现
 * @param <T>
 */
public class ListBag<T> implements Bag<T> {

    private int n;

    /**
     * 背包首节点
     */
    private Node<T> first;

    public ListBag() {}

    @Override
    public void add(T item) {
        final Node<T> oriFirst = first;
        first = new Node<>(item, oriFirst);
        n ++;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListBagIterator();
    }

    class ListBagIterator implements Iterator<T> {

        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return Objects.nonNull(current);
        }

        @Override
        public T next() {
            final T item = current.getItem();
            current = current.getNext();
            return item;
        }
    }

}
