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

    @Parameter(names = "-k", description = "Index in storage")
    public String index;

    @Parameter(names = "-v", description = "Message to store", variableArity = true)
    public String value;

    @Parameter(names = "-in", description = "Read request from file", variableArity = true)
    public String file;

    public String getSentMessageText() {
        if (type.equalsIgnoreCase("exit")) return "exit";
        if (type.equalsIgnoreCase("set")) {
            return "set " + index + " " + value;
        }
        return type + " " + index;
    }
}