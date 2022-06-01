package com.vkostylev.patterns.command.client;

import com.beust.jcommander.JCommander;
import com.vkostylev.patterns.command.Param;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
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
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Client started!");
            output.writeObject(mArgs);
            System.out.println("Sent: " + mArgs.getSentMessageText());
            String serverMessage = input.readUTF();
            Thread.sleep(1000);
            System.out.println("Received: " + serverMessage);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}