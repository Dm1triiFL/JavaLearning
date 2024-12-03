package org.example.part_5;

import java.util.ArrayList;
import java.util.List;

class Calendar {

    // Список выходных и праздничных дней
    private List<Day> days;

    public Calendar() {
        days = new ArrayList<>();
    }

    // Метод для добавления дня (выходного или праздничного)
    public void addDay(int day, int month, int year, boolean holiday) {
        days.add(new Day(day, month, year, holiday));
    }

    // Метод для отображения всех дней
    public void showDays() {
        for (Day day : days) {
            System.out.println(day);
        }
    }

    // Внутренний класс Day для представления дня
    private class Day {
        private int day;
        private int month;
        private int year;
        private boolean holiday;

        public Day(int day, int month, int year, boolean holiday) {
            this.day = day;
            this.month = month;
            this.year = year;
            this.holiday = holiday;
        }

        @Override
        public String toString() {
            String type = holiday ? "Праздничный" : "Выходной";
            return day + "/" + month + "/" + year + " - " + type;
        }
    }

    public static void main(String[] args) {
        System.out.println("Шубин Дмитрий Б762-2 Вариант 12");
        Calendar calendar = new Calendar();
        calendar.addDay(1, 1, 2024, true);
        calendar.addDay(8, 3, 2024, true);
        calendar.addDay(7, 5, 2024, false);
        calendar.addDay(1, 5, 2024, true);

        calendar.showDays();
    }
}
