package com.bascker.algorithm.practice.stack;

import com.bascker.algorithm.base.ElasticStack;
import com.bascker.algorithm.base.ListQueue;
import com.bascker.algorithm.base.ListStack;
import com.bascker.algorithm.base.Queue;
import com.bascker.algorithm.base.Stack;
import com.bascker.algorithm.common.ConvertUtil;
import com.bascker.common.Operator;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * 获取一个缺少左括号的表达式，并打印出补全括号的中序表达式
 * input:  1+2)*3-4)*5-6)))
 * output: ((1+2)*((3-4)*(5-6)))
 *
 * @author bascker
 * @since v1.0
 */
public class CompleteExpression {

    private static final CompleteExpression instance = new CompleteExpression();

    public static final CompleteExpression getInstance() {
        return instance;
    }

    public static final List<String> OPS = Lists.newArrayList(Operator.ADD.val(), Operator.SUB.val(),
            Operator.MUL.val(), Operator.DEV.val());

    public static final List<String> VALS = IntStream.range(1, 10).boxed()
            .map(i -> Integer.toString(i)).collect(Collectors.toList());

    public String complete(final String expression) {
        if (StringUtils.isEmpty(expression)) {
            return expression;
        }


        // 运算符栈
        final Stack<String> ops = new ListStack<>();
        // 操作数队列
        final Queue<String> vals = new ListQueue<>();
        // 存储结果的 StringBuilder
        final StringBuilder sb = new StringBuilder();
        System.out.println(VALS.toString());
        for (char c : expression.toCharArray()) {
            final String ch = String.valueOf(c);

            // FIXME
            // step1: 若为右括号
            if (StringUtils.equals(Operator.BRACKET_RIGHT.val(), ch) && vals.isNotEmpty()) {
                sb.append(Operator.BRACKET_LEFT.val())
                        .append(vals.dequeue()).append(ops.pop()).append(vals.dequeue())
                        .append(ch);
            }

            // step2: 若为操作符
            if (OPS.contains(ch)) {
                ops.push(ch);
            }

            // step3: 若为数字
            if (VALS.contains(ch)) {
                vals.enqueue(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getInstance().complete("1+2)*3-4)*5-6)))"));
    }

}
