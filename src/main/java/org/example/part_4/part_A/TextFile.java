package org.example.part_4.part_A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile extends File {

    public TextFile(String name, Directory directory) {
        super(name, directory);
    }

    @Override
    public void create() throws IOException {
        try (FileWriter writer = new FileWriter(directory.getPath() + java.io.File.separator + name)) {
            System.out.println("Файл '" + name + "' успешно создан.");
        }
    }

    @Override
    public void rename(String newName) throws IOException {
        java.io.File oldFile = new java.io.File(directory.getPath() + java.io.File.separator + name);
        java.io.File newFile = new java.io.File(directory.getPath() + java.io.File.separator + newName);
        if (!oldFile.renameTo(newFile)) {
            throw new IOException("Ошибка при переименовании файла.");
        }
        name = newName;
        System.out.println("Файл переименован в '" + name + "'.");
    }

    @Override
    public void append(String content) throws IOException {
        try (FileWriter writer = new FileWriter(directory.getPath() + java.io.File.separator + name, true)) {
            writer.write(content);
            System.out.println("Текст успешно добавлен в файл '" + name + "'.");
        }
    }

    @Override
    public void display() throws IOException {
        java.io.File file = new java.io.File(directory.getPath() + java.io.File.separator + name);
        if (!file.exists()) {
            throw new IOException("Файл '" + name + "' не существует.");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("Содержимое файла '" + name + "':");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    @Override
    public void delete() throws IOException {
        java.io.File fileToDelete = new java.io.File(directory.getPath() + java.io.File.separator + name);
        if (!fileToDelete.exists()) {
            throw new IOException("Файл '" + name + "' не существует.");
        }
        if (!fileToDelete.delete()) {
            throw new IOException("Ошибка при удалении файла.");
        }
        System.out.println("Файл '" + name + "' успешно удален.");
    }

    @Override
    public String toString() {
        return "TextFile{" +
                "name='" + name + '\'' +
                ", directory=" + directory +
                '}';
    }
}
