package com.vkostylev.patterns.command.server;

public class GetCommand implements Command {
    private Storage storage;
    private int index;


    public GetCommand(Storage storage, int index) {
        this.storage = storage;
        this.index = index;
    }

    @Override
    public String execute() {
        return storage.get(index);
    }
}
