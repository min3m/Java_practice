package oncall;
import oncall.controller.ScheduleController;

public class Application {
    public static void main(String[] args) {
        ScheduleController controller = new ScheduleController();
        controller.run();
    }
}
