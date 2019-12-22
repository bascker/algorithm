package com.bascker.algorithm.base;

import java.util.Iterator;

public class ElasticStack<T> implements Stack<T> {

    private int n;

    private T[] container;

    public ElasticStack(int capacity) {
        container = (T[]) new Object[capacity];
    }

    @Override
    public void push(T item) {
        if (n == container.length / 2) {
            resize(container.length * 2);
        }
        container[n ++] = item;
    }

    @Override
    public T pop() {
        final T item = container[-- n];
        container[n] = null;
        if (n > 0 && n == container.length / 4) {
            resize(container.length / 2);
        }

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

    /**
     * 获取当前栈的容量
     * @return
     */
    public int getCapacity() {
        return container.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new ElasticStackIterator();
    }

    private void resize(int capacity) {
        T[] arr = (T[]) new Object[capacity];
        for (int i = 0; i < n; i ++) {
            arr[i] = container[i];
        }
        container = arr;
    }

    class ElasticStackIterator implements Iterator<T> {

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
