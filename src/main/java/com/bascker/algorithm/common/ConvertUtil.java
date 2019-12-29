package com.bascker.algorithm.common;

import com.bascker.algorithm.base.Bag;
import com.bascker.algorithm.base.Queue;
import com.bascker.algorithm.base.Stack;


public class ConvertUtil {

    public static <T> String toString(final Iterable<T> iterable, final String seperator) {
        final StringBuilder sb = new StringBuilder();
        for (T item : iterable) {
            sb.append(item).append(seperator);
        }
        if (sb.length() >= seperator.length()) {
            sb.replace(sb.length() - seperator.length(), sb.length(), Constant.EMPTY);
        }

        return sb.toString();
    }

    public static <T> String bag2String(final Bag<T> bag) {
        return toString(bag, Constant.ARROW_RIGHT);
    }

    public static <T> String queue2String(final Queue<T> queue) {
        return toString(queue, Constant.ARROW_RIGHT);
    }

    public static <T> String stack2Sting(final Stack<T> stack) {
        return toString(stack, Constant.ARROW_RIGHT);
    }

    private ConvertUtil () {}

}
