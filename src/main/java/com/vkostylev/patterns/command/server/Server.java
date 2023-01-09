package com.vkostylev.patterns.command.server;
/*
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.vkostylev.libs.gson.JsonStorage;
import com.vkostylev.patterns.command.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //private static JsonFileStorage storage;
    public static void main(String[] args) {
        String address = "127.0.0.1";
        int port = 23456;
        boolean run = true;
        Controller controller = new Controller();
        System.out.println("Server started!");

        try {
            storage = new JsonFileStorage();
            ServerSocket server = new ServerSocket(port, 50, InetAddress.getByName(address));
            while (run) {
                Socket socket = server.accept();
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String message = input.readUTF();
                JsonObject clientMessage = new Gson().fromJson(message, JsonObject.class);
                JsonObject response = new JsonObject();

                switch (clientMessage.get("type").getAsString()) {
                    case "exit":
                        run = false;
                        response.addProperty("response","OK");
                        output.writeUTF(response.toString());
                        break;
                    case "get":
                         response = storage.get(clientMessage.get("key").getAsString());
                         output.writeUTF(response.toString());
                        break;
                    case "set":
                        response = storage.set(clientMessage.get("key").getAsString(), clientMessage.get("value").getAsString());
                        output.writeUTF(response.toString());
                        break;
                    case "delete":
                        response = storage.delete(clientMessage.get("key").getAsString());
                        output.writeUTF(response.toString());
                        break;
                    default:
                        response.addProperty("response","ERROR");
                        response.addProperty("reason", "Operation unsupported");
                        output.writeUTF(response.toString());
                }
                //System.out.println("storage now: " + storage.getStorage());
            }
            server.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}

 */