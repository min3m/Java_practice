package oncall.model;

public class Date {
    private final int month;
    private final String day;

    private Date(int month, String day) {
        this.month = month;
        this.day = day;
    }

    public int getMonth() {return month; }
    public String getDay() { return day; }

    public static Date of(int month, String day) {
        return new Date(month, day);
    }
}
