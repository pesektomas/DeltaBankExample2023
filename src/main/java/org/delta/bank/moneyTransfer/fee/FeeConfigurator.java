package org.delta.bank.moneyTransfer.fee;

public class FeeConfigurator {

    private boolean isFreeFee;

    private double baseFee;

    private double percentLimit;

    private double basePercent;

    public FeeConfigurator() {
        this.isFreeFee = true;
        this.baseFee = 0;
        this.percentLimit = 0;
        this.basePercent = 0;
    }

    public FeeConfigurator(double baseFee, double percentLimit, double basePercent) {
        this.isFreeFee = false;
        this.baseFee = baseFee;
        this.percentLimit = percentLimit;
        this.basePercent = basePercent;
    }

    public double getBaseFee() {
        return baseFee;
    }

    public double getPercentLimit() {
        return percentLimit;
    }

    public double getBasePercent() {
        return basePercent;
    }

    public boolean isFreeFee() {
        return isFreeFee;
    }
}
