package com.bascker.algorithm.base;

import java.util.Iterator;
import java.util.Objects;

public class ListQueue<T> implements Queue<T> {

    private int n;

    /**
     * 指向队头(最早添加的节点)
     */
    private Node<T> first;

    /**
     * 指向队尾(最近添加的节点)
     */
    private Node<T> last;

    public ListQueue () {}

    @Override
    public void enqueue(T item) {
        Node<T> oriLast = last;
        last = new Node<>(item, null);
        if (isEmpty()) {
            first = last;
        } else {
            oriLast.setNext(last);
        }

        n ++;
    }

    @Override
    public T dequeue() {
        final T item = first.getItem();

        final Node<T> oriFirst = first;
        first = first.getNext();
        oriFirst.setNext(null);

        if (isEmpty()) {
            last = null;
        }
        n --;

        return item;
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
        return new ListQueueIterator();
    }

    class ListQueueIterator implements Iterator<T> {

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
