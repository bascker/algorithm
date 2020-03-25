package com.bascker.algorithm.base;

import java.util.Iterator;
import java.util.Objects;

/**
 * Stack 的链表实现
 * @param <T>
 */
public class ListStack<T> implements Stack<T> {

    private int n;

    /**
     * first 指针跟踪栈顶
     */
    private ListNode<T> first;

    public ListStack () {}

    @Override
    public void push(T item) {
        final ListNode<T> oriFirst = first;
        first = new ListNode<>(item, oriFirst);
        n ++;
    }

    @Override
    public T pop() {
        final T item = first.getItem();

        final ListNode<T> oriFirst = first;
        first = first.getNext();
        oriFirst.setNext(null);

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
    public T peek() {
        return first.getItem();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListStackIterator();
    }

    class ListStackIterator implements Iterator<T> {

        private ListNode<T> current = first;

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
