package com.bascker.algorithm.common;

import java.util.Optional;

public class Constant {

    // -------------------------
    // String Const
    // -------------------------

    public static final String EMPTY = "";

    public static final String BLANK = " ";

    public static final String ARROW_RIGHT = "->";

    public static final String NEW_LINE = "\n";

    // ---------------------------
    // 枚举类
    // ---------------------------

    /**
     * 运算符
     */
    public enum Operator {
        ADD("+"), SUB("-"), MUL("*"), DEV("/"),
        BRACKET_LEFT("("), BRACKET_RIGHT(")"), BRACKET_MID_LEFT("["), BRACKET_MID_RIGHT("]"),
        BRACE_LEFT("{"), BRACE_RIGHT("}");

        private String op;

        Operator(String op) {
            this.op = op;
        }

        public String val() {
            return op;
        }

    }

}
