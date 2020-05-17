package com.bascker.algorithm.practice.stack;

import com.bascker.algorithm.base.stack.ListStack;
import com.bascker.algorithm.base.Stack;
import com.bascker.common.Constant;
import com.bascker.common.Operator;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;


/**
 * 获取一个缺少左括号的表达式，并打印出补全括号的中序表达式
 * input:  1+2)*3-4)*5-6)))
 * output: ((1+2)*((3-4)*(5-6)))
 *
 * @author bascker
 * @version v1.0
 * @from 算法4 T1.3.9
 */
public class CompleteExpression {

    private static final CompleteExpression instance = new CompleteExpression();

    public static CompleteExpression getInstance() {
        return instance;
    }

    private static final List<Character> OPS = Lists.newArrayList(Operator.ADD.val(), Operator.SUB.val(),
            Operator.MUL.val(), Operator.DEV.val());

    /**
     * 双栈法
     */
    public String complete(final String expression) {
        if (StringUtils.isEmpty(expression)) {
            return expression;
        }

        // 运算符栈
        final Stack<Character> ops = new ListStack<>();
        // 操作数队列
        final Stack<String> datas = new ListStack<>();

        for (char c : expression.toCharArray()) {
            // step1 若为数字，则进栈
            if ('1' <= c && c <= '9') {
                datas.push(String.valueOf(c));
            }
            // step2 若是操作数，则进操作数栈
            else if (OPS.contains(c)) {
                ops.push(c);
            }
            // step3 否则遇到右括号，则出栈：2个操作数，1个运算符
            else {
                String a = datas.pop();
                String b = datas.pop();

                // step4 将补齐的表达式放入 datas 中
                String s = new StringBuilder().append(Constant.BRACKET_LEFT)
                        .append(b).append(ops.pop()).append(a)
                        .append(Constant.BRACKET_RIGHT).toString();
                datas.push(s);
            }
        }

        // step5 栈顶出栈：栈顶就是最全的表达式
        return datas.pop();
    }

}
