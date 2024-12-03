package org.example.part_4.part_B.mobile.model;

public class PremiumTariff extends Tariff {
    private int dataLimit;

    public PremiumTariff(String name, double monthlyFee, int dataLimit) {
        super(name, monthlyFee);
        this.dataLimit = dataLimit;
    }

    public int getDataLimit() {
        return dataLimit;
    }
}
