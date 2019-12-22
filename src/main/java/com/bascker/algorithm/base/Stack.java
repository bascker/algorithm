package com.bascker.algorithm.base;

/**
 * LIFO: last in first out
 * @param <T>
 */
public interface Stack<T> extends Iterable<T> {

    /**
     * push object to stack
     * @param item object, the item could be null
     */
    void push(T item);

    T pop();

    int size();

    boolean isEmpty();

}
