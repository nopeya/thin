package com.thin.core;

import com.thin.core.exception.NotDefineException;
import com.thin.core.exception.ValidationFailedException;
import com.thin.utils.AssertUtils;

import java.util.function.Predicate;

/**
 * 命令执行顶层接口
 * 所有命令需继承或实现这个接口
 * @author: hi@hackfree.cn
 * @Date: 2020/10/4 9:50
 */
public interface BaseCommand<T> {

    /**
     * 命令前置校验器，必须实现才能调用。
     * @author: hi@hackfree.cn
     * @Date: 2020/10/5 17:53
     */
    default void validate(T t) {

        Predicate<T> validator = this.getValidator();
        AssertUtils.isTrue(validator != null, new NotDefineException("No definition found for validation！"));

        if (!validator.test(t))
            throw new ValidationFailedException("Validation test failed！");
        System.out.println("validation passed");
    }

    void execute();

    default Predicate<T> getValidator() {
        return null;
    }
}
