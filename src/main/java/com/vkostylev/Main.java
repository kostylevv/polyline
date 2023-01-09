package com.vkostylev;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Main {
    private static final String BASE_PATH ="/src/main/java/com/vkostylev/patterns/command/client/data/";


    public static void main(String[] args) {
        Gson gson = new Gson();
        try {
            String fileContent = readFileAsString(BASE_PATH+"json.json");
            JsonObject convertedObject = new Gson().fromJson(fileContent, JsonObject.class);

            // JsonObject tree = gson.toJsonTree(fileContent).getAsJsonObject();
            for(Map.Entry<String, JsonElement> entry : convertedObject.entrySet()) {
                System.out.println("Key = " + entry.getKey() + " Value = " + entry.getValue() );

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            }
    }

    private static String readFileAsString(String relativePathToFile) throws IOException {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        return new String(Files.readAllBytes(Paths.get(s+relativePathToFile)));
    }

    //https://www.interviewcake.com/question/java/find-rotation-point
    public static int rotationPointFinder(String[] words) {
        /*
        For run:
        String[] words = new String[]{
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "asymptote",  // <-- rotates here!
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
        };
        System.out.println(rotationPointFinder(words));
         */
        //@TODO binary search modification
        String previous = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].compareTo(previous) < 0) {
                return i;
            }
            previous = words[i];
        }
        return -1;
    }

    public static String reverse(String string) throws IllegalArgumentException {
        if (string == null) throw new IllegalArgumentException("Provided string is null");
        int l = string.length();
        char[] charsIn = new char[l];
        char[] charsOut = new char[l];
        string.getChars(0, l, charsIn,0);
        for (int i = l-1, j = 0; i >= 0; i--, j++) {
            charsOut[i] = charsIn[j];
        }
        String result = new String(charsOut);
        return result;
    }
}
