package com.vkostylev.patterns.command.client;

import com.beust.jcommander.JCommander;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.vkostylev.patterns.command.Param;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Client {
    private static final String BASE_PATH ="/src/main/java/com/vkostylev/patterns/command/client/data/";

    private static String readFileAsString(String relativePathToFile) throws IOException {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        return new String(Files.readAllBytes(Paths.get(s+relativePathToFile)));
    }

    public static void main(String[] args) {
        try {
            Param mArgs = new Param();
            JCommander.newBuilder()
                    .addObject(mArgs)
                    .build()
                    .parse(args);
            String address = "127.0.0.1";
            int port = 23456;
            Socket socket = new Socket(InetAddress.getByName(address), port);
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            System.out.println("Client started!");
            JsonObject request = new JsonObject();
            if (mArgs.file != null) {
                //System.out.println("has file with path: " + PATH+mArgs.file);
                String fileContent = readFileAsString(BASE_PATH+mArgs.file);
                System.out.println(fileContent);
                request = new Gson().fromJson(fileContent, JsonObject.class);
            } else {
                request.addProperty("type", mArgs.type);
                if (!mArgs.type.equalsIgnoreCase("exit")) {
                    request.addProperty("key", mArgs.index);
                }
                if (mArgs.type.equalsIgnoreCase("set")) {
                    request.addProperty("value", mArgs.value);
                }
            }
            output.writeUTF(request.toString());
            System.out.println("Sent: " + request.toString());
            String serverMessage = input.readUTF();
            Thread.sleep(1000);
            System.out.println("Received: " + serverMessage);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}