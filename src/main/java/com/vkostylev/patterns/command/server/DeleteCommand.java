package com.vkostylev.patterns.command.server;

public class DeleteCommand implements Command {
    private Storage storage;
    private int index;

    public DeleteCommand(Storage storage, int index) {
        this.storage = storage;
        this.index = index;
    }

    @Override
    public String execute() {
        return storage.delete(index);
    }
}
