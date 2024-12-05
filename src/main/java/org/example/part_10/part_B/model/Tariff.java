package org.example.part_10.part_B.model;

import java.io.Serializable;

public abstract class Tariff implements Serializable {
    private static final long serialVersionUID = 1L; // Уникальный идентификатор версии
    protected String name;
    protected double monthlyFee;
    protected transient int customerCount; // Не сериализуемое поле

    public Tariff(String name, double monthlyFee) {
        this.name = name;
        this.monthlyFee = monthlyFee;
        this.customerCount = 0;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public String getName() {
        return name;
    }

    public void addCustomer() {
        customerCount++;
    }

    public int getCustomerCount() {
        return customerCount;
    }

}

