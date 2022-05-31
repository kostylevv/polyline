package com.vkostylev.patterns.command;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        String address = "127.0.0.1";
        int port = 23456;
        boolean run = true;
        Storage storage = new Storage(1000);
        Controller controller = new Controller();
        System.out.println("Server started!");

        try {
            ServerSocket server = new ServerSocket(port, 50, InetAddress.getByName(address));
            while (run) {
                Socket socket = server.accept();
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                Param clientMessage = (Param) input.readObject();

                switch (clientMessage.type) {
                    case "exit":
                        run = false;
                        output.writeUTF("OK");
                        break;
                    case "get":
                        Command get = new GetCommand(storage, clientMessage.index);
                        controller.setCommand(get);
                        output.writeUTF(controller.executeCommand());
                        break;
                    case "set":
                        Command set = new SetCommand(storage, clientMessage.index, clientMessage.message);
                        controller.setCommand(set);
                        output.writeUTF(controller.executeCommand());
                    case "delete":
                        Command delete = new DeleteCommand(storage, clientMessage.index);
                        controller.setCommand(delete);
                        output.writeUTF(controller.executeCommand());
                        break;
                    default:
                        System.out.println("Operation unsupported (recieved: " + clientMessage + ")");
                }
            }
            server.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}