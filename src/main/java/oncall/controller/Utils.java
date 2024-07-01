package oncall.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import oncall.model.Holiday;
import oncall.model.Regex;

public class Utils {

    public static List<String> splitByRegex(String input) {
        return (List.of(input.split(Regex.COMMA.getRegex())));
    }

    public static boolean isWeekend(String week) {
        if (week.equals("토") || week.equals("일")) {
            return true;
        }
        return false;
    }

    public static boolean isHoliday(int month, int day, String week) {
        return Arrays.stream(Holiday.values())
                .anyMatch(h -> h.getMonth() == month && h.getDay() == day);
    }
}
