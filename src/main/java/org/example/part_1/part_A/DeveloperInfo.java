package org.example.part_1.part_A;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeveloperInfo {
    public void displayInfo() {
        String developerSurname = "Шубин"; // Заменить на реальную фамилию
        LocalDateTime assignmentDate = LocalDateTime.of(2024, 11, 4, 17, 56); // Пример
        LocalDateTime submissionDate = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("Фамилия разработчика: " + developerSurname);
        System.out.println("Дата и время получения задания: " + assignmentDate.format(formatter));
        System.out.println("Дата и время сдачи задания: " + submissionDate.format(formatter));
    }
}
