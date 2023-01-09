package com.vkostylev.patterns.command.server;

import com.google.gson.JsonObject;

public class JsonObjectStorage {

    private final JsonObject storage, noSuchKey;

    public JsonObjectStorage() {
        storage = new JsonObject();

        //{ "response": "ERROR", "reason": "No such key" }
        noSuchKey = new JsonObject();
        noSuchKey.addProperty("response", "ERROR");
        noSuchKey.addProperty("reason", "No such key");
    }

    public String getStorage(){
        return storage.toString();
    }
/*
    public JsonObject get(JsonObject key) {
        JsonObject result;
        if (key != null && storage.) {
            result.addProperty("response", "OK");
            result.addProperty("value", storage.get(key).getAsString());
        } else {
            result = noSuchKey;
        }
        return result;
    }
*/
    public JsonObject delete(String key) {
        JsonObject result = new JsonObject();
        if (key != null && storage.has(key)) {
            storage.remove(key);
            result.addProperty("response", "OK");
        } else {
            result = noSuchKey;
        }
        return result;
    }

    public JsonObject set(String key, String value) {
        storage.addProperty(key, value);
        JsonObject result = new JsonObject();
        result.addProperty("response", "OK");
        return result;
    }

    public static void main(String[] args) {
        JsonStorage storage = new JsonStorage();
        System.out.println(storage.set("k1", "v1"));
        System.out.println(storage.set("k2", "v2"));
        System.out.println(storage.set("k3", "v3"));
        System.out.println(storage.get("k1"));
        System.out.println(storage.get("k2"));
        System.out.println(storage.getStorage());
        System.out.println(storage.delete("k2"));
        System.out.println(storage.getStorage());

    }
}
