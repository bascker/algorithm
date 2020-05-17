package com.bascker.algorithm.practice.stack;

import com.bascker.algorithm.base.stack.ListStack;
import com.bascker.algorithm.base.Stack;
import com.bascker.common.Constant;
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

    private static final Map<Character, Character> MATCHES = new ImmutableMap.Builder<Character, Character>()
            .put(Constant.BRACE_LEFT, Constant.BRACE_RIGHT)
            .put(Constant.BRACKET_LEFT, Constant.BRACKET_RIGHT)
            .put(Constant.BRACKET_MID_LEFT, Constant.BRACKET_MID_RIGHT)
            .build();

    public static BracketMatch getInstance() {
        return instance;
    }

    public boolean isMatch(final String s) {
        if (StringUtils.isEmpty(s)) {
            return false;
        }

        final Stack<Character> stack = new ListStack<>();
        for (int i = 0; i < s.length(); i ++) {
            final Character item = s.charAt(i);
            // step1. 若是左括号，则入栈
            if (MATCHES.keySet().contains(item)) {
                stack.push(item);
            }
            // step2. 若是右括号，且栈非空，则出栈。并判断出栈的元素是否与当前操作数 item 是否匹配
            else if (MATCHES.values().contains(item) && BooleanUtils.isFalse(stack.isEmpty())) {
                final char v = stack.pop();
                if (BooleanUtils.isFalse(MATCHES.get(v) == item)) {
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
