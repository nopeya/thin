package com.thin.core.supports;

import com.thin.core.BaseCommand;
import com.thin.core.CommandSelector;
import com.thin.core.annotation.Command;
import com.thin.utils.AssertUtils;
import com.thin.utils.CollectionUtils;
import com.thin.utils.PackageUtils;
import com.thin.utils.StringUtils;
import lombok.Data;
import lombok.var;

import java.util.List;
import java.util.function.Predicate;

/**
 * 注解命令选择器
 * @author: hi@hackfree.cn
 * @Date: 2020/10/4 23:18
 */
@Data
public class AnnotationCommandSelector implements CommandSelector {

    private final static String COMMANDS_PACKAGE_PATH = "com.thin.app.commands";

    public BaseCommand find(String command) {

        try {

            AssertUtils.isTrue(StringUtils.isNotBlank(command));

            Predicate<Class> classPredicate = clazz ->
                    BaseCommand.class.isAssignableFrom(clazz) && clazz.isAnnotationPresent(Command.class);

            List<Class> classList = PackageUtils.getClassList(COMMANDS_PACKAGE_PATH, classPredicate);
            if (CollectionUtils.isNotEmpty(classList)) {
                Class target = classList.stream()
                        .filter(clazz -> {
                            Command annotation = (Command) clazz.getAnnotation(Command.class);
                            return annotation.command().trim().equals(command.trim());
                        })
                        .findFirst().orElse(null);
                if (target != null) {
                    return (BaseCommand) target.newInstance();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        var v = 20;
        AnnotationCommandSelector selector = new AnnotationCommandSelector();
        BaseCommand order = selector.find("order");
        if (order != null) {
            order.validate(v);
        }
    }
}
