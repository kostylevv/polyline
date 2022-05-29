package com.vkostylev.libs.jcommander;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    @Parameter
    private List<String> parameters = new ArrayList<>();

    @Parameter(names = { "-log", "-verbose" }, description = "Level of verbosity")
    private Integer verbose = 1;

    @Parameter(names = "-groups", description = "Comma-separated list of group names to be run")
    private String groups;

    @Parameter(names = "-debug", description = "Debug mode")
    private boolean debug = false;

    public static void main(String[] args) {
        Main mArgs = new Main();
        String[] argv = { "-log", "2", "-groups", "unit" };
        JCommander.newBuilder()
                .addObject(mArgs)
                .build()
                .parse(argv);

        System.out.println(mArgs.groups);

    }
}
