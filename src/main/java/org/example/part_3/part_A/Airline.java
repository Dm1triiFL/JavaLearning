package org.example.part_3.part_A;

import java.util.ArrayList;
import java.util.List;

public class Airline {
    private List<Flight> flights;

    public Airline() {
        flights = new ArrayList<>();
        // Добавление примеров рейсов
        flights.add(new Flight("Москва", "SU101", "A320", "14:30", new String[]{"Пн", "Ср", "Пт"}));
        flights.add(new Flight("Сочи", "SU202", "B737", "15:45", new String[]{"Вт", "Чт", "Сб"}));
        flights.add(new Flight("Москва", "SU303", "A320", "18:00", new String[]{"Пн", "Ср", "Сб"}));
        flights.add(new Flight("Казань", "SU404", "A321", "16:15", new String[]{"Пн", "Чт"}));
    }

    public List<Flight> getFlightsByDestination(String destination) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDestination().equalsIgnoreCase(destination)) {
                result.add(flight);
            }
        }
        return result;
    }

    public List<Flight> getFlightsByDayOfWeek(String day) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            for (String flightDay : flight.getDaysOfWeek()) {
                if (flightDay.equalsIgnoreCase(day)) {
                    result.add(flight);
                    break;
                }
            }
        }
        return result;
    }

    public List<Flight> getFlightsByDayAndTime(String day, String minTime) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            for (String flightDay : flight.getDaysOfWeek()) {
                if (flightDay.equalsIgnoreCase(day) && flight.getDepartureTime().compareTo(minTime) > 0) {
                    result.add(flight);
                    break;
                }
            }
        }
        return result;
    }
}
