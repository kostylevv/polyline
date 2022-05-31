package com.vkostylev.patterns.command;

import java.util.HashSet;
import java.util.Set;

public class Storage {
    private String[] storage;
    private Set<String> commandsSet = new HashSet<String>();
    private int size;

    public Storage(int size) {
        storage = new String[size];
        this.size = size;
        commandsSet.add("set");
        commandsSet.add("get");
        commandsSet.add("delete");
    }

    public boolean hasCommand(String command) {
        return commandsSet.contains(command.toLowerCase());
    }

    public boolean inRange(int index) {
        return (index >= 0) && (index < size);
    }

    private void checkRangeAndContent(int index) throws IllegalArgumentException {
        if (!this.inRange(index)) throw new IllegalArgumentException("Index provided is out of range. Index is " + index + ", size is " + size);
        if (storage[index] == null) throw new IllegalArgumentException("Requested cell is empty");
    }

    public String get(int index) throws IllegalArgumentException {
        try {
            this.checkRangeAndContent(index-1);
            return storage[index-1];
        } catch (IllegalArgumentException ie) {
             //System.out.println(ie);
            return "ERROR";
        }
    }

    public String set(int index, String word) throws IllegalArgumentException {
        if (inRange(index-1)) {
            storage[index-1] = word;
            //System.out.println("index: " + (index-1));
            //System.out.println("req to store:" + word);
            //System.out.println("actually stored: " + storage[index-1]);
            return "OK";
        } else return "ERROR";
    }

    public String delete(int index) throws IllegalArgumentException {
        if (inRange(index-1)) {
            storage[index-1] = null;
            //System.out.println("index: " + index);
            //System.out.println("req to store:" + word);
            //System.out.println("actually stored: " + storage[index]);
            return "OK";
        } else return "ERROR";
    }

}