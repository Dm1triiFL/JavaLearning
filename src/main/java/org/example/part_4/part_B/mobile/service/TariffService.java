package org.example.part_4.part_B.mobile.service;


import org.example.part_4.part_B.mobile.model.Tariff;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TariffService {
    private List<Tariff> tariffs;

    public TariffService() {
        this.tariffs = new ArrayList<>();
    }

    public void addTariff(Tariff tariff) {
        tariffs.add(tariff);
    }

    public int getTotalCustomers() {
        return tariffs.stream().mapToInt(Tariff::getCustomerCount).sum();
    }

    public List<Tariff> sortTariffsByMonthlyFee() {
        tariffs.sort(Comparator.comparingDouble(Tariff::getMonthlyFee));
        return tariffs;
    }

    public List<Tariff> findTariffsInRange(double min, double max) {
        List<Tariff> result = new ArrayList<>();
        for (Tariff tariff : tariffs) {
            if (tariff.getMonthlyFee() >= min && tariff.getMonthlyFee() <= max) {
                result.add(tariff);
            }
        }
        return result;
    }

    public List<Tariff> getTariffs() {
        return tariffs;
    }

    public void displayTariffs() {
        if (tariffs.isEmpty()) {
            System.out.println("Нет доступных тарифов.");
            return;
        }
        System.out.println("Список тарифов:");
        for (Tariff tariff : tariffs) {
            System.out.println(tariff.getName());
        }
    }
}
