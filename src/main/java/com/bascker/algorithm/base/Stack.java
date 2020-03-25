package com.bascker.algorithm.base;

/**
 * LIFO: last in first out
 * @param <T>
 */
public interface Stack<T> extends Iterable<T> {

    // -----------------------
    // Base Function
    // -----------------------

    /**
     * push object to stack
     * @param item object, the item could be null
     */
    void push(T item);

    T pop();

    int size();

    boolean isEmpty();

    /**
     * get the last element, but not pop it
     * @return the top element
     */
    T peek();

    // ---------------------
    // Extend Function
    // ---------------------
    default boolean isNotEmpty() {
        return !isEmpty();
    }

}
