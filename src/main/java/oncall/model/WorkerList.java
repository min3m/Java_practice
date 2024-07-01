package oncall.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WorkerList {
    private final List<Worker> weekdayWorkers;
    private final List<Worker> holidayWorkers;

    WorkerList(List<Worker> weekdayWorkers, List<Worker> holidayWorkers) {
        this.weekdayWorkers = weekdayWorkers;
        this.holidayWorkers = holidayWorkers;
    }

    public List<Worker> getWeekdayWorkers() {
        return weekdayWorkers;
    }

    public List<Worker> getHolidayWorkers() {
        return holidayWorkers;
    }

    public static WorkerList of(List<String> weekdayWorkers, List<String> holidayWorkers) {
        return new WorkerList(weekdayWorkers.stream()
                .map(Worker::of)
                .toList()
                , holidayWorkers.stream()
                .map(Worker::of)
                .toList());
    }
}
