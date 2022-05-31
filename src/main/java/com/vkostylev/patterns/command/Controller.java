package com.vkostylev.patterns.command;

public class Controller {
    //invoker

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public String executeCommand() {
        return command.execute();
    }
}