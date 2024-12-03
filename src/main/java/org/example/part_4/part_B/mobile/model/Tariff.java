package org.example.part_4.part_B.mobile.model;

public abstract class Tariff {
    protected String name;
    protected double monthlyFee;
    protected int customerCount;

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

