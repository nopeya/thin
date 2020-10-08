package com.thin.app.commands;

import com.thin.core.BaseCommand;
import com.thin.core.annotation.Command;

@Command(command = "app.pay")
public class Pay implements BaseCommand {

    public void execute() {
        System.out.println("have paid");
    }
}
