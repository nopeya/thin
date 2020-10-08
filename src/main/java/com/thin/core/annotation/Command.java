package com.thin.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 *
 * @author: hi@hackfree.cn
 * @Date: 2020/10/4 23:20
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface Command {

    String command();
}
