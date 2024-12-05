package org.example.part_10.part_B.service;

import org.example.part_10.part_B.model.Tariff;

import java.io.*;
import java.util.List;

public class TariffConnector {

    private static final String FILE_NAME = "tariffs.ser";

    // Метод для сохранения тарифов в файл
    public void saveTariffs(List<Tariff> tariffs) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tariffs);
            System.out.println("Тарифы успешно сохранены.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении тарифов: " + e.getMessage());
        }
    }

    // Метод для загрузки тарифов из файла
    @SuppressWarnings("unchecked")
    public List<Tariff> loadTariffs() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            List<Tariff> tariffs = (List<Tariff>) ois.readObject();
            System.out.println("Тарифы успешно загружены.");
            return tariffs;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке тарифов: " + e.getMessage());
            return null;
        }
    }
}
