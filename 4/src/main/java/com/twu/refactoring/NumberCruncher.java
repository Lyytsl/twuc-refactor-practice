package com.twu.refactoring;

import java.util.function.IntPredicate;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return getCount(number -> number % 2 == 0);
    }

    public int countOdd() {
        return getCount(number -> number % 2 != 0);
    }

    public int countPositive() {
        return getCount(number -> number >= 0);
    }

    public int countNegative() {
        return getCount(number -> number < 0);
    }

    private int getCount(IntPredicate intPredicate) {
        int count = 0;
        for (int number : numbers) {
            if (intPredicate.test(number)) count++;
        }
        return count;
    }
}
