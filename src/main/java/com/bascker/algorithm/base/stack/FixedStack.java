package com.bascker.algorithm.base.stack;

import com.bascker.algorithm.base.Stack;

import java.util.Iterator;

/**
 * Fixed Capacity Stack
 * @param <T>
 */
public class FixedStack<T> implements Stack<T> {

    private int n;

    private final T[] container;

    public FixedStack(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    public void push(T item) {
        container[n ++] = item;
    }

    public T pop() {
        final T item = container[-- n];
        container[n] = null;
        return item;
    }

    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public T peek() {
        return container[n - 1];
    }

    public boolean isFull() {
        return n == container.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new FixedStackIterator();
    }

    class FixedStackIterator implements Iterator<T> {

        private int index = n - 1;

        @Override
        public boolean hasNext() {
            return index > -1;
        }

        @Override
        public T next() {
            return container[index --];
        }
    }

}