package com.bascker.algorithm.base;

/**
 * LIFO, Not supports remove item from it
 * @param <T>
 */
public interface Bag<T> extends Iterable<T> {

    void add(T item);

    int size();

    boolean isEmpty();
}
