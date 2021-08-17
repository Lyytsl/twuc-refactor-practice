package com.twu.refactoring;

public class Receipt {

    private final Taxi taxi;

    public Receipt(Taxi taxi) {
        this.taxi = taxi;
    }

    public double getTotalCost() {
        double totalCost = 0;

        totalCost = totalCost + ReceiptEnum.of(ReceiptEnum.Type.FIXED_CHARGE);

        int totalKms = taxi.getTotalKms();
        double peakTimeMultiple = taxi.isPeakTime() ? ReceiptEnum.of(ReceiptEnum.Type.PEAK_TIME_MULTIPLIER) : ReceiptEnum.of(ReceiptEnum.Type.OFF_PEAK_MULTIPLIER);
        if (taxi.isAirConditioned()) {
            totalCost = getTotalCost(totalCost, totalKms, peakTimeMultiple);
        } else {
            totalCost = getCost(totalCost, totalKms, peakTimeMultiple);
        }

        return totalCost * (1 + ReceiptEnum.of(ReceiptEnum.Type.SALES_TAX_RATE));
    }

    private double getTotalCost(double totalCost, int totalKms, double peakTimeMultiple) {
        double rate = ReceiptEnum.of(ReceiptEnum.Type.RATE_CHANGE_DISTANCE);
        double post = ReceiptEnum.of(ReceiptEnum.Type.PRE_RATE_CHANGE_AC_RATE);
        totalCost += Math.min(rate, totalKms) * post * peakTimeMultiple;
        totalCost += Math.max(0, totalKms - rate) * post * peakTimeMultiple;
        return totalCost;
    }

    private double getCost(double totalCost, int totalKms, double peakTimeMultiple) {
        double path = ReceiptEnum.of(ReceiptEnum.Type.RATE_CHANGE_DISTANCE);
        double pre = ReceiptEnum.of(ReceiptEnum.Type.PRE_RATE_CHANGE_NON_AC_RATE);
        totalCost += Math.min(path, totalKms) * pre * peakTimeMultiple;
        totalCost += Math.max(0, totalKms - path) * pre * peakTimeMultiple;
        return totalCost;
    }
}
