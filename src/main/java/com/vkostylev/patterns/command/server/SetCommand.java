package com.vkostylev.patterns.command.server;

public class SetCommand implements Command {
        private Storage storage;
        private int index;
        private String message;

        public SetCommand(Storage storage, int index, String message) {
            this.storage = storage;
            this.index = index;
            this.message = message;
        }

        @Override
        public String execute() {
            return storage.set(index, message);
        }
    }
