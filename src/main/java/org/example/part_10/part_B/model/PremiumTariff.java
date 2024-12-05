package org.example.part_10.part_B.model;

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
