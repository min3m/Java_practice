package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import oncall.controller.Validator;
import oncall.model.Date;
import oncall.model.Message;
import oncall.model.Regex;
import oncall.model.WorkerList;

import java.util.List;

import static oncall.controller.Utils.splitByRegex;

public class Input {

    Input() {
    }

    public static Input of() {
        return new Input();
    }

    public Date readDate() {
        try {
            System.out.print(Message.DATE_MSG.getMsg());
            String inputDate = Console.readLine();
            List<String> date = splitByRegex(inputDate);
            Validator.validateDate(date);
            return Date.of(Integer.parseInt(date.get(0)), date.get(1));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readDate();
        }
    }

    public WorkerList readWorkers() {
        try {
            System.out.print(Message.WEEKDAY_MSG.getMsg());
            List<String> weekdayWorkers = readWeekdayWorkers();
            System.out.print(Message.HOLIDAY_MSG.getMsg());
            List<String> weekendWorkers = readHolidayWorkers();
            return WorkerList.of(weekdayWorkers, weekendWorkers);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWorkers();
        }
    }

    private List<String> readWeekdayWorkers() {
        String inputWorkers = Console.readLine();
        List<String> weekdayWorkers = splitByRegex(inputWorkers);
        Validator.validateWorker(weekdayWorkers);
        return weekdayWorkers;
    }

    private List<String> readHolidayWorkers() {
        String inputWorkers = Console.readLine();
        List<String> holidayWorkers = splitByRegex(inputWorkers);
        Validator.validateWorker(holidayWorkers);
        return holidayWorkers;
    }
}