package org.example.part_4.part_B.mobile.model;


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

