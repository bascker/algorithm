package com.bascker.algorithm.common;

import com.bascker.algorithm.base.Stack;

public class ConvertUtil {

    public static <T> String stack2Sting(final Stack<T> stack) {
        final StringBuilder sb = new StringBuilder();
        for (T item : stack) {
            sb.append(item).append(Constant.ARROW_RIGHT);
        }
        if (sb.length() >= Constant.ARROW_RIGHT.length()) {
            sb.replace(sb.length() - Constant.ARROW_RIGHT.length(), sb.length(), Constant.EMPTY);
        }

        return sb.toString();
    }

    private ConvertUtil () {}

}
