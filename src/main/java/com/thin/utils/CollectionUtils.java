package com.thin.utils;

import java.util.Collection;

/**
 *
 * @author: hi@hackfree.cn
 * @Date: 2020/10/4 23:19
 */
public class CollectionUtils {

    public static boolean isEmpty(Collection coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isNotEmpty(Collection coll) {
        return !isEmpty(coll);
    }

}
