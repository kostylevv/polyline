package com.vkostylev.libs.jcommander;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    @Parameter
    private List<String> parameters = new ArrayList<>();

    @Parameter(names = { "-t", "-type" }, description = "Type of command")
    private String type;

    @Parameter(names = "-i", description = "Index in storage")
    private int index = -1;

    @Parameter(names = "-m", description = "Message to store", variableArity = true)
    private List<String> message;

    public static void main(String[] args) {
        String words = "-t set -i 148 -m Here is some text to store on the server";
        Main mArgs = new Main();
        //String[] argv = { "-log", "2", "-groups", "unit" };
        String[] argc = words.split(" ");
        JCommander.newBuilder()
                .addObject(mArgs)
                .build()
                .parse(argc);

        System.out.println(mArgs.type);
        System.out.println(mArgs.index);
        System.out.println(mArgs.message);
        StringBuilder msg = new StringBuilder();
        for (String word : mArgs.message) {
            msg.append(word + " ");
        }
        System.out.println(msg.toString());

    }
}
