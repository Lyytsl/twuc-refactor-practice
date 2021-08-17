package com.twu.refactoring;

public class ReceiptEnum {

    private Type type;

    public ReceiptEnum(Type value) {

    }

    public static Double of(Type value) {
        return Double.valueOf(String.valueOf(new ReceiptEnum(value)));
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        FIXED_CHARGE(50),
        PEAK_TIME_MULTIPLIER(1.2),
        OFF_PEAK_MULTIPLIER(1.0),
        RATE_CHANGE_DISTANCE(10),
        PRE_RATE_CHANGE_NON_AC_RATE(15),
        POST_RATE_CHANGE_NON_AC_RATE(12),
        PRE_RATE_CHANGE_AC_RATE(20),
        POST_RATE_CHANGE_AC_RATE(17),
        SALES_TAX_RATE(0.1);

        private final Double description;

        Type(double description) {

            this.description = description;
        }

        public Double getDescription() {
            return description;
        }
    }
}
