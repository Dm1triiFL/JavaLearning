package org.example.part_4.part_A;


public class Main {
    public static void main(String[] args) {
        System.out.println("Шубин Дмитрий Б762-2 Вариант 12");

        Directory directory = new Directory("my_directory"); // Создаем новую директорию
        TextFile textFile = new TextFile("example.txt", directory); // Создаем новый текстовый файл


        textFile.create(); // Создаем файл
        textFile.append("Hello, world!\n"); // Дополняем файл
        textFile.display(); // Выводим содержимое
        textFile.rename("new_example.txt"); // Переименовываем файл
        textFile.display(); // Выводим новое содержимое
        textFile.delete(); // Удаляем файл
    }
}



