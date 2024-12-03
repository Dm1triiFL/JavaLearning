package org.example.part_2.part_B;

public class MonthName {
    public void printMonthName(int monthNumber) {
        String[] months = {
                "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
        };

        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Некорректный номер месяца! Пожалуйста, введите число от 1 до 12.");
        } else {
            System.out.println("Месяц: " + months[monthNumber - 1]);
        }
    }
}
