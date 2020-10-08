package com.thin.utils;

/**
 *
 * @author: hi@hackfree.cn
 * @Date: 2020/10/4 23:19
 */
public class StringUtils {

    public static boolean isBlank(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

}
