package org.example.part_14.part_A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MessageServer {

    private List<String> clients;

    public MessageServer(String filename) {
        clients = new ArrayList<>();
        loadClients(filename);
    }

    private void loadClients(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                clients.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        for (String client : clients) {
            String[] parts = client.split(":");
            String host = parts[0];
            int port = Integer.parseInt(parts[1]);
            try (Socket socket = new Socket(host, port);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                out.println(message);
                System.out.println("Отправлено сообщение \"" + message + "\" клиенту: " + client);
            } catch (IOException e) {
                System.out.println("Не удалось отправить сообщение клиенту: " + client);
            }
        }
    }

    public static void main(String[] args) {
        MessageServer server = new MessageServer("src\\main\\resources\\part_14\\part_A\\clients.txt");
        server.sendMessage("Привет, это тестовое сообщение!");
    }
}
