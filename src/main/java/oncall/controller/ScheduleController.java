package oncall.controller;

import oncall.model.*;
import oncall.service.WorkerService;
import oncall.view.Input;
import oncall.view.Ouptut;

public class ScheduleController {
    private final Input input = Input.of();
    private final Ouptut ouptut = Ouptut.of();
    private final WorkerService workerService = WorkerService.of();

    public void run() {
        Date date = input.readDate();
        WorkerList workerList = input.readWorkers();
        String schedule = makeSchedule(date, workerList);
        ouptut.printSchedule(schedule);
    }

    private String makeSchedule(Date date, WorkerList workerList) {
        int month = date.getMonth();
        int maxDay = Month.findMaxDay(month);
        String week = date.getDay();
        StringBuilder message = new StringBuilder();

        for (int day = 1; day <= maxDay; day++) {
            Worker worker = workerService.todayWorker(workerList, month, day, week);
            message.append(month).append("월 ").append(day).append("일 ").append(week).append(" ");
            if (!Utils.isWeekend(week) && Utils.isHoliday(month, day, week))
                message.append("(휴일) ");
            message.append(worker.getName()).append("\n");
            week = Week.next(week);
        }
        return message.toString();
    }
}
