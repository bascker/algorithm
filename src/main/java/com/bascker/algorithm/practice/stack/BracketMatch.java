package com.bascker.algorithm.practice.stack;

import com.bascker.algorithm.base.ListStack;
import com.bascker.algorithm.base.Stack;
import com.bascker.algorithm.common.Constant;
import com.bascker.common.Operator;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 括号匹配: 判断括号是否配对完整
 * @author bascker
 */
public class BracketMatch {

    private static final BracketMatch instance = new BracketMatch();

    private static final Map<String, String> MATCHES = new ImmutableMap.Builder<String, String>()
            .put(Operator.BRACE_LEFT.val(), Operator.BRACE_RIGHT.val())
            .put(Operator.BRACKET_LEFT.val(), Operator.BRACKET_RIGHT.val())
            .put(Operator.BRACKET_MID_LEFT.val(), Operator.BRACKET_MID_RIGHT.val())
            .build();

    public static BracketMatch getInstance() {
        return instance;
    }

    public boolean isMatch(final String s) {
        if (StringUtils.isEmpty(s)) {
            return false;
        }

        final Stack<String> stack = new ListStack<>();
        for (int i = 0; i < s.length(); i ++) {
            final String item = String.valueOf(s.charAt(i));
            // step1. 若是左括号，则入栈
            if (MATCHES.keySet().contains(item)) {
                stack.push(item);
            }
            // step2. 若是右括号，且栈非空，则出栈。并判断出栈的元素是否与当前操作数 item 是否匹配
            else if (MATCHES.values().contains(item) && BooleanUtils.isFalse(stack.isEmpty())) {
                final String v = stack.pop();
                if (BooleanUtils.isFalse(StringUtils.equals(MATCHES.get(v), item))) {
                    return false;
                }
            }
            // step3. 若不是括号，则返回 false
            else {
                return false;
            }
        }

        return stack.isEmpty();
    }

}
