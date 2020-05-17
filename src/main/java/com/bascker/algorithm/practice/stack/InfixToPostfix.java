package com.bascker.algorithm.practice.stack;

import com.bascker.algorithm.base.Stack;
import com.bascker.algorithm.base.stack.ListStack;
import com.bascker.common.Constant;
import com.bascker.common.Operator;
import org.apache.commons.lang3.StringUtils;

/**
 * 将中序表达式表达式转后序表达式
 *
 * in =  2*3/(2-1)+3*(4-1)
 * out = 23*21-/341-*+
 *
 * @author bascker
 * @version v1.0
 * @from 算法4 T1.3.10
 */
public class InfixToPostfix {

    public String solution(String infix) {
        if (StringUtils.isEmpty(infix)) {
            return "";
        }

        final StringBuilder sb = new StringBuilder();
        final Stack<Character> op = new ListStack<>();

        for (int i = 0, len = infix.length(); i < len; ++ i) {
            char ch = infix.charAt(i);
            // step1: 若是操作数，则直接输出到结果池
            if ('1' <= ch && ch <= '9') {
                sb.append(ch);
            }
            // step2: 若是运算符
            else if (Operator.isOperator(ch)) {
                op.push(ch);
            }
            // step3: 若是左括号
            else if (Constant.BRACKET_LEFT == ch) {
                op.push(ch);
            }
        }


        return sb.toString();
    }

}
