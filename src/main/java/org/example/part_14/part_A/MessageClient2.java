package org.example.part_14.part_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageClient2 {
    public static void main(String[] args) {
        int port = 8082;
        startClient(port);
    }

    private static void startClient(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Клиент 2 запущен и слушает на порту " + port);
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String message = in.readLine();
                    System.out.println("Клиент 2 получил сообщение: " + message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
