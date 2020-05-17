package com.bascker.algorithm.base.stack;

import com.bascker.algorithm.base.Stack;


public class StackFactory {

    private StackFactory() {

    }

    public static <T> Stack<T> newFixedStack(int capacity) {
        return new FixedStack<>(capacity);
    }

    public static <T> Stack<T> newElasticStack(int capacity) {
        return new ElasticStack<>(capacity);
    }

    public static <T> Stack<T> newListStack() {
        return new ListStack<>();
    }

}
