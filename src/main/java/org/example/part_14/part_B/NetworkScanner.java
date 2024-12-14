package org.example.part_14.part_B;

import java.net.InetAddress;
import java.net.UnknownHostException;
//Вариант 3 Шубин Дмитрий

public class NetworkScanner {
    public static void main(String[] args) {
        String baseIP = "192.168.1.";
        int start = 1;
        int end = 254;

        for (int i = start; i <= end; i++) {
            String ip = baseIP + i;
            try {
                InetAddress address = InetAddress.getByName(ip);
                if (address.isReachable(1000)) {
                    System.out.println(ip + " доступен.");
                } else {
                    System.out.println(ip + " недоступен.");
                }
            } catch (UnknownHostException e) {
                System.out.println(ip + " неизвестный хост.");
            } catch (Exception e) {
                System.out.println("Ошибка проверки " + ip + ": " + e.getMessage());
            }
        }
    }
}
