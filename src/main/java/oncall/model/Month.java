package oncall.model;

import java.util.Arrays;
import java.util.Objects;

public enum Month {
    JAN(1, 31),
    FEB(2, 28),
    MAR(3, 31),
    APR(4, 30),
    MAY(5, 31),
    JUN(6, 30),
    JUL(7, 31),
    AUG(8, 31),
    SEP(9, 30),
    OCT(10, 31),
    NOV(11, 30),
    DEC(12, 31);

    private final int month;
    private final int maxDay;

    Month(int month, int maxDay) {
        this.month = month;
        this.maxDay = maxDay;
    }

    public int getMonth() {
        return this.month;
    }

    public int getMaxDay() {
        return this.maxDay;
    }

    public static int findMaxDay(int month) {
        return Arrays.stream(values())
                .filter(m -> m.month == month)
                .findFirst()
                .map(Month::getMaxDay)
                .orElse(0);
    }
}
