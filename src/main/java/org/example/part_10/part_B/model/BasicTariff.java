package org.example.part_10.part_B.model;


public class BasicTariff extends Tariff {
    private int smsLimit;

    public BasicTariff(String name, double monthlyFee, int smsLimit) {
        super(name, monthlyFee);
        this.smsLimit = smsLimit;
    }

    public int getSmsLimit() {
        return smsLimit;
    }
}

