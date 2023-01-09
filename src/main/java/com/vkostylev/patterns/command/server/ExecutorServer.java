package com.vkostylev.patterns.command.server;
/*
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.vkostylev.libs.gson.JsonStorage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class ExecutorServer {
    //private static JsonFileStorage storage;
    private final ExecutorService exec = Executors.newCachedThreadPool();
    private static ServerSocket socket;

    private void start() throws IOException {
        socket = new ServerSocket(23456);
        while (!exec.isShutdown()) {
            try {
                final Socket conn = socket.accept();
                exec.execute(new Runnable() {
                    @Override
                    public void run() {
                        handleRequest(conn);
                    }
                });
            } catch (RejectedExecutionException rejectedExecutionException) {
                if(!exec.isShutdown()) {
                    System.out.println("task submission rejected:" + rejectedExecutionException.getMessage());
                }
            } catch (IOException ioException) {
                //System.out.println("ioe");
            }
        }
    }

    private void stop() throws IOException {
        exec.shutdownNow();
        System.out.println(exec.isShutdown());
        socket.close();
    }

    public static void main(String[] args) {
        ExecutorServer server = new ExecutorServer();
        try {
            storage = new JsonFileStorage();
            System.out.println("Server started!");
            server.start();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    private void handleRequest(Socket connection)  {
        try {
            DataInputStream input = new DataInputStream(connection.getInputStream());
            DataOutputStream output = new DataOutputStream(connection.getOutputStream());
            String message = input.readUTF();
            JsonObject clientMessage = new Gson().fromJson(message, JsonObject.class);
            JsonObject response = new JsonObject();

        switch (clientMessage.get("type").getAsString()) {
            case "exit":
                response.addProperty("response","OK");
                output.writeUTF(response.toString());
                stop();
                break;
            case "get":
                response = (JsonObject) storage.get(clientMessage.get("key"));
                output.writeUTF(response.toString());
                break;
            case "set":
                response = storage.set(clientMessage.get("key"), clientMessage.get("value"));
                output.writeUTF(response.toString());
                break;
            case "delete":
                response = storage.delete(clientMessage.get("key"));
                output.writeUTF(response.toString());
                break;
            default:
                response.addProperty("response","ERROR");
                response.addProperty("reason", "Operation unsupported");
                output.writeUTF(response.toString());
        }
            connection.close();
    } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

*/