package com.bascker.algorithm.common;

import com.bascker.algorithm.base.Bag;
import com.bascker.algorithm.base.Queue;
import com.bascker.algorithm.base.Stack;
import com.bascker.common.CastUtils;


public class ConvertUtil {

    public static <T> String bag2String(final Bag<T> bag) {
        return CastUtils.toString(bag, Constant.ARROW_RIGHT);
    }

    public static <T> String queue2String(final Queue<T> queue) {
        return CastUtils.toString(queue, Constant.ARROW_RIGHT);
    }

    public static <T> String stack2Sting(final Stack<T> stack) {
        return CastUtils.toString(stack, Constant.ARROW_RIGHT);
    }

    private ConvertUtil () {}

}
