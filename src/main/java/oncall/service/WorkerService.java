package oncall.service;

import oncall.controller.Utils;
import oncall.model.Holiday;
import oncall.model.Worker;
import oncall.model.WorkerList;

import java.security.interfaces.RSAKey;
import java.util.Arrays;
import java.util.List;

public class WorkerService {
    private int holidayIndex;
    private int weekdayIndex;
    Worker beforeWorker;
    Worker skipWorker;

    WorkerService() {
        holidayIndex = 0;
        weekdayIndex = 0;
        beforeWorker = null;
        skipWorker = null;
    }

    public static WorkerService of() {
        return new WorkerService();
    }

    public Worker todayWorker(WorkerList workerList, int month, int day, String week) {
        List<Worker> holidayWorkers = workerList.getHolidayWorkers();
        List<Worker> weekdayWorkers = workerList.getWeekdayWorkers();

        if (Utils.isHoliday(month, day, week) || Utils.isWeekend(week)) {
            return findHolidayWorker(holidayWorkers);
        }
        return findWeekdayWorker(weekdayWorkers);
    }

    private Worker findHolidayWorker(List<Worker> holidayWorkers) {
        if (skipWorker != null) {
            beforeWorker = skipWorker;
            skipWorker = null;
            holidayIndex = (holidayIndex + 1) % holidayWorkers.size();
            return beforeWorker;
        }
        if (beforeWorker != null && holidayWorkers.get(holidayIndex).getName().equals(beforeWorker.getName())) {
            skipWorker = holidayWorkers.get(holidayIndex);
            holidayIndex = (holidayIndex + 1) % holidayWorkers.size();
            beforeWorker = holidayWorkers.get(holidayIndex);
            return beforeWorker;
        }
        beforeWorker = holidayWorkers.get(holidayIndex);
        holidayIndex = (holidayIndex + 1) % holidayWorkers.size();
        return beforeWorker;
    }

    private Worker findWeekdayWorker(List<Worker> weekdayWorkers) {
        if (skipWorker != null) {
            beforeWorker = skipWorker;
            skipWorker = null;
            weekdayIndex = (weekdayIndex + 1) % weekdayWorkers.size();
            return skipWorker;
        }
        if (beforeWorker != null && weekdayWorkers.get(weekdayIndex).getName().equals(beforeWorker.getName())) {
            skipWorker = weekdayWorkers.get(weekdayIndex);
            weekdayIndex = (weekdayIndex + 1) % weekdayWorkers.size();
            beforeWorker = weekdayWorkers.get(weekdayIndex);
            return beforeWorker;
        }
        beforeWorker = weekdayWorkers.get(weekdayIndex);
        weekdayIndex = (weekdayIndex + 1) % weekdayWorkers.size();
        return beforeWorker;
    }
}
