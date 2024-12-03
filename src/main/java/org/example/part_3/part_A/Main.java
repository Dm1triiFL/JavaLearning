package org.example.part_3.part_A;

public class Main {
    public static void main(String[] args) {
        System.out.print("Шубин Дмитрий Б762-2 Вариант 12");
        Airline airline = new Airline();

        // Пример использования
        System.out.println("Рейсы в Москву:");
        for (Flight flight : airline.getFlightsByDestination("Москва")) {
            System.out.println(flight.getFlightNumber() + " - " + flight.getDepartureTime());
        }

        System.out.println("\nРейсы по понедельникам:");
        for (Flight flight : airline.getFlightsByDayOfWeek("Пн")) {
            System.out.println(flight.getFlightNumber() + " - " + flight.getDepartureTime());
        }

        System.out.println("\nРейсы по понедельникам после 16:00:");
        for (Flight flight : airline.getFlightsByDayAndTime("Пн", "16:00")) {
            System.out.println(flight.getFlightNumber() + " - " + flight.getDepartureTime());
        }
    }
}
