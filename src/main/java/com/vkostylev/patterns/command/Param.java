package com.vkostylev.patterns.command;

import com.beust.jcommander.Parameter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Param implements Serializable {
    @Parameter
    public List<String> parameters = new ArrayList<>();

    @Parameter(names = { "-t", "-type" }, description = "Type of command")
    public String type;

    @Parameter(names = "-i", description = "Index in storage")
    public int index = -1;

    @Parameter(names = "-m", description = "Message to store", variableArity = true)
    public String message;

    public String getSentMessageText() {
        if (type.equalsIgnoreCase("exit")) return "exit";
        if (type.equalsIgnoreCase("set")) {
            return "set " + index + " " + message;
        }
        return type + " " + index;
    }
}