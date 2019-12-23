package com.bascker.algorithm.base;

/**
 * FIFO: first in first out
 * @param <T>
 */
public interface Queue<T> extends Iterable<T> {

    void enqueue(T item);

    T dequeue();

    int size();

    boolean isEmpty();

}
