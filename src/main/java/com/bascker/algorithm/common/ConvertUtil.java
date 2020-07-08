package com.bascker.algorithm.common;

import com.bascker.algorithm.base.Bag;
import com.bascker.algorithm.base.ListNode;
import com.bascker.algorithm.base.Queue;
import com.bascker.algorithm.base.Stack;
import com.bascker.common.CastUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;


public class ConvertUtil {

    public static <T> String bag2BeautyString(final Bag<T> bag) {
        return CastUtils.toString(bag, Constant.ARROW_RIGHT);
    }

    public static <T> String queue2String(final Queue<T> queue) {
        return CastUtils.toString(queue);
    }

    public static <T> String queue2BeautyString(final Queue<T> queue) {
        return CastUtils.toString(queue, Constant.ARROW_RIGHT);
    }

    public static <T> String stack2String(final Stack<T> stack) {
        return CastUtils.toString(stack);
    }

    public static <T> String stack2BeautySting(final Stack<T> stack) {
        return CastUtils.toString(stack, Constant.ARROW_RIGHT);
    }

    public static <T> String list2String(final ListNode<T> head) {
        return CastUtils.toString(head);
    }

    public static <T> String list2BeautyString(final ListNode<T> head) {
        return CastUtils.toString(head, Constant.ARROW_RIGHT);
    }

    public static ListNode<Integer> string2List(final String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        ListNode<Integer> head = null;
        ListNode<Integer> tail = null;
        char[] chs = str.toCharArray();

        for (char c : chs) {
            if (Objects.isNull(head)) {
                head = new ListNode<>(CastUtils.castInt(c), null);
                tail = head;
            } else {
                ListNode<Integer> node = new ListNode<>(CastUtils.castInt(c), null);
                tail.setNext(node);
                tail = node;
            }
        }

        return head;
    }

    public static <T> ListNode<T> arr2List(final T[] arr) {
        ListNode<T> head = null;
        ListNode<T> tail = null;
        for (T t : arr) {
            if (head == null) {
                head = new ListNode<>(t, null);
                tail = head;
            } else {
                ListNode<T> node = new ListNode<>(t, null);
                tail.setNext(node);
                tail = node;
            }
        }

        return head;
    }

    public static String arr2String(int[][] arrs) {
        return Arrays.stream(arrs).map(Arrays::toString)
                .collect(Collectors.joining(",", "[", "]"));
    }

    private ConvertUtil () {}

}
