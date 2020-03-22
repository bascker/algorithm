package com.bascker.algorithm;

import com.bascker.algorithm.base.ListStack;
import com.bascker.algorithm.base.Stack;
import com.bascker.algorithm.common.Constant;
import com.bascker.common.Operator;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

/**
 * Dijkstra 中缀算数表达式求值算法
 *
 * TODO: 待优化以下场景
 *  1. 简单计算不带左右括号: 如 1 + 0
 *  2. 小数点: 如 1 + 0.0
 *  3. 算术符号非单字符时: 如 s(1 + sqrt(4))
 */
public class DijkstraEvaluate {

    /**
     * 支持的运算符
     */
    private static final Set<String> OPS = Sets.newHashSet(Operator.ADD.val(),
            Operator.SUB.val(), Operator.MUL.val(), Operator.DEV.val());

    private static final DijkstraEvaluate instance = new DijkstraEvaluate();

    private DijkstraEvaluate() {};

    public static DijkstraEvaluate getInstance() {
        return instance;
    }

    public String evaluate(String string) {
        if (StringUtils.isEmpty(string)) {
            return "0";
        }

        // 运算符栈
        final Stack<String> ops = new ListStack<>();
        // 操作数栈
        final Stack<Double> vals = new ListStack<>();
        for (int i = 0; i < string.length(); i ++) {
            final String s = String.valueOf(string.charAt(i));

            // step1. 若是左括号或空格，则忽略
            if (StringUtils.equals(Operator.BRACKET_LEFT.val(), s) || StringUtils.isBlank(s)) {
                continue;
            }

            // step2. 若是运算符，则压入运算符栈
            if (OPS.contains(s)) {
                ops.push(s);
            }
            // step3. 若是右括号, 则弹出运算符和操作数，并将结果压入操作数栈
            else if (StringUtils.equals(Operator.BRACKET_RIGHT.val(), s))
            {
                final double val = vals.pop();
                final String op = ops.pop();

                double rs = val;
                if (StringUtils.equals(Operator.ADD.val(), op)) {
                    rs = vals.pop() + val;
                } else if (StringUtils.equals(Operator.SUB.val(), op)) {
                    rs = vals.pop() - val;
                } else if (StringUtils.equals(Operator.MUL.val(), op)) {
                    rs = vals.pop() * val;
                } else if (StringUtils.equals(Operator.DEV.val(), op)) {
                    rs = vals.pop() / val;
                }

                vals.push(rs);
            }
            // step4. 若是操作数，则压入操作数栈
            else {
                vals.push(Double.parseDouble(s));
            }
        }

        return String.valueOf(vals.pop());
    }

}
