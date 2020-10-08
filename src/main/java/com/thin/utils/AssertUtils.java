package com.thin.utils;

/**
 *
 * @author: hi@hackfree.cn
 * @Date: 2020/10/4 23:20
 */
public class AssertUtils {

    public static void isTrue(boolean expression) {
        isTrue(expression, new IllegalArgumentException("illegal argument exception!"));
    }

    public static void isTrue(boolean expression, String message) {
        isTrue(expression, new RuntimeException(message));
    }

    public static void isTrue(boolean expression, RuntimeException exception) {
        if (!expression) {
            throw exception;
        }
    }
}
