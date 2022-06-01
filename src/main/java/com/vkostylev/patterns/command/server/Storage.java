package com.vkostylev.patterns.command.server;

public class Storage {
    private final String[] storage;
    private final int size;

    public Storage(int size) {
        storage = new String[size];
        this.size = size;
    }

    public boolean inRange(int index) {
        return (index >= 0) && (index < size);
    }

    public String get(int index) {
        if (inRange(index-1) && storage[index-1]!= null) {
            return storage[index-1];
        } else return "ERROR";
    }

    public String set(int index, String word) {
        if (inRange(index-1)) {
            storage[index-1] = word;
            return "OK";
        } else return "ERROR";
    }

    public String delete(int index) {
        if (inRange(index-1)) {
            storage[index-1] = null;
            return "OK";
        } else return "ERROR";
    }
}