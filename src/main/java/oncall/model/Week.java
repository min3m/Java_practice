package oncall.model;

import java.util.Arrays;

public enum Week {
    MON("월"),
    TUE("화"),
    WED("수"),
    THR("목"),
    FRI("금"),
    SAT("토"),
    SUN("일");

    private final String weekDay;

    Week(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getWeekDay() {
        return this.weekDay;
    }

    public static Boolean findWeek(String week){
        //stream 이용해서 처리 가능.
        for (Week w : values()) {
            if (w.getWeekDay().equals(week))
                return true;
        }
        return false;
    }

    public static String next(String week){
        for (int i = 0; i < values().length; i++) {
            if (values()[i].getWeekDay().equals(week)) {
                return values()[(i + 1) % 7].getWeekDay();
            }
        }
        throw new IllegalArgumentException("Error : No matches data");
    }
}
