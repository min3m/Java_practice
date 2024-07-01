package oncall.view;

import java.util.List;

public class Ouptut {

    Ouptut() {
    }

    public static Ouptut of() {
        return new Ouptut();
    }

    public void printSchedule(String schedule) {
        System.out.println(schedule);
    }
}
