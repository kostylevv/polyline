package com.vkostylev.patterns.command.server;
/*
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class JsonFileStorage {

    private JsonObject storage, noSuchKey;
    private static final ReadWriteLock lock = new ReentrantReadWriteLock();
    private static final Lock readLock = lock.readLock();
    private static final Lock writeLock = lock.writeLock();

    private static final String PATH = "./src/main/java/com/vkostylev/patterns/command/server/data/db.json";

    public static boolean hasStorageFile(String filename) {
        return Files.exists(Paths.get(filename));
    }

    public static String readFileAsString(String fileName) throws IOException {
        readLock.lock();
        String result = new String(Files.readAllBytes(Paths.get(fileName)));
        readLock.unlock();
        return result;
    }

    public JsonFileStorage() throws IOException {
        storage = new JsonObject();
        Path path = Paths.get(PATH);
        System.out.println(path);
        if (hasStorageFile(PATH)) {
            String dataString = readFileAsString(PATH);
            if (dataString.length() > 0) {
                storage = new Gson().fromJson(dataString, JsonObject.class);
            }
        } else {
            Files.createFile(Paths.get(PATH));
        }

        noSuchKey = new JsonObject();
        noSuchKey.addProperty("response", "ERROR");
        noSuchKey.addProperty("reason", "No such key");
    }

    public String getStorage(){
        return storage.toString();
    }

    private void rewriteStorageFile() throws IOException {
        writeLock.lock();
        Files.delete(Paths.get(PATH));
        Files.createFile(Paths.get(PATH));
        Files.write(Paths.get(PATH), storage.toString().getBytes(StandardCharsets.UTF_8));
        writeLock.unlock();
    }

    public JsonElement get(JsonElement key) {
        JsonObject result = new JsonObject();
            if (key.isJsonPrimitive() && storage.has(key.getAsString())) {
                result.addProperty("response", "OK");
                result.add("value", storage.get(key.getAsString()));
            } else if (key.isJsonArray()) {
                JsonElement element = findElement(key.getAsJsonArray(), false);
                if (element != null) {
                    result.addProperty("response", "OK");
                    result.add("value", element);
                } else {
                    result = noSuchKey;
                }
            } else {
                result = noSuchKey;
            }
        return result;
    }

    public JsonObject delete(JsonElement key) throws IOException {
        JsonObject result = new JsonObject();
        if (key.isJsonPrimitive() && storage.has(key.getAsString())) {
            storage.remove(key.getAsString());
            rewriteStorageFile();
            result.addProperty("response", "OK");
        } else if (key.isJsonArray()) {
            JsonArray keys = key.getAsJsonArray();
            String toRemove = keys.remove(keys.size()-1).getAsString();
            findElement(keys, false).getAsJsonObject().remove(toRemove);
            rewriteStorageFile();
            result.addProperty("response", "OK");
        } else {
            result = noSuchKey;
        }
        return result;
    }

    public JsonObject set(JsonElement key, JsonElement value) throws IOException {
        JsonObject result = new JsonObject();
        if (key.isJsonPrimitive() && storage.has(key.getAsString())) {
            storage.add(key.getAsString(), value);
            rewriteStorageFile();
            result.addProperty("response", "OK");
        } else if (key.isJsonArray()) {
            JsonArray keys = key.getAsJsonArray();
            String toAdd = keys.remove(keys.size()-1).getAsString();
            findElement(keys, true).getAsJsonObject().add(toAdd, value);
            rewriteStorageFile();
            result.addProperty("response", "OK");
        } else {
            result = noSuchKey;
        }
        return result;
    }

    private JsonElement findElement(JsonArray keys, boolean createIfAbsent) {
        JsonElement tmp = storage;
        if (createIfAbsent) {
            for (JsonElement key: keys) {
                if (!tmp.getAsJsonObject().has(key.getAsString())) {
                    tmp.getAsJsonObject().add(key.getAsString(), new JsonObject());
                }
                tmp = tmp.getAsJsonObject().get(key.getAsString());
            }
        } else {
            for (JsonElement key: keys) {
                if (!key.isJsonPrimitive() || !tmp.getAsJsonObject().has(key.getAsString())) {
                    return null;
                }
                tmp = tmp.getAsJsonObject().get(key.getAsString());
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        try {
            JsonFileStorage jsonFileStorage = new  JsonFileStorage();
            jsonFileStorage.set("1","v1");
            System.out.println(jsonFileStorage.getStorage());
            jsonFileStorage.set("2","v2");
            System.out.println(jsonFileStorage.getStorage());
            jsonFileStorage.get("1");
            jsonFileStorage.delete("2");
            System.out.println(jsonFileStorage.getStorage());
        } catch (Exception ioException) {
            ioException.printStackTrace();
        }

    }
}
*/