package com.thin.app.commands;

import com.thin.core.supports.AnnotationCommandSelector;
import com.thin.core.BaseCommand;
import com.thin.core.CommandSelector;
import com.thin.core.annotation.Command;
import lombok.var;

import java.util.function.Predicate;

@Command(command = "app.order")
public class Order implements BaseCommand<Integer> {

    public void execute() {
        System.out.println("order a goods");
    }

    @Override
    public Predicate<Integer> getValidator() {
        return i -> i != null && i > 10;
    }

    public static void main(String[] args) {

        CommandSelector selector = new AnnotationCommandSelector();
        BaseCommand order = selector.find("app.order");

        var target = 15;

        order.validate(target);
        order.execute();
    }
}
