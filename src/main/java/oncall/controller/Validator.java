package oncall.controller;

import java.util.Arrays;
import java.util.List;
import oncall.model.Regex;
import oncall.model.Message;
import oncall.model.Week;

public class Validator {

    Validator() {
    }

    public static void validateDate(List<String> date) {
        validateMonth(date.get(0));
        validateWeek(date.get(1));
    }

    private static void validateMonth(String number) {
        //parseInt로 바꿔도 됨. 여기서 던지는 exception이 Illegal exception을 받음.
        if (number.matches(Regex.NUMBER.getRegex())) {
            throw new IllegalArgumentException(Message.ERROR_MSG.getMsg());
        }
        int month = Integer.parseInt(number);
        if (month < 1 || month > 12)
            throw new IllegalArgumentException(Message.ERROR_MSG.getMsg());
    }

    private static void validateWeek(String week) {
        if (!Week.findWeek(week))
            throw new IllegalArgumentException(Message.ERROR_MSG.getMsg());
    }

    public static void validateWorker(List<String> workers) {
        validateWorkerName(workers);
        validateWorkerListNumber(workers);
        validateWorkersDuplicate(workers);
    }

    private static void validateWorkerName(List<String> workers) {
        for (String worker : workers) {
            if (worker.length() > 5)
                throw new IllegalArgumentException(Message.ERROR_MSG.getMsg());
        }
    }

    private static void validateWorkerListNumber(List<String> workers) {
        if (workers.size() < 5 || workers.size() > 35)
            throw new IllegalArgumentException(Message.ERROR_MSG.getMsg());
    }

    private static void validateWorkersDuplicate(List<String> workers) {
        if (workers.size() != workers.stream().distinct().count())
            throw new IllegalArgumentException(Message.ERROR_MSG.getMsg());
    }
}
