package oncall.model;

public enum Holiday {
    SINJUNG(1, 1),
    SAMILJUL(3, 1),
    CHILDDAY(5, 5),
    HYUNCHUNGIL(6, 6),
    GWANGBOKJUL(8, 15),
    GAECHUNJUL(10, 3),
    HANGEULNAL(10, 9),
    CHRISTMAS(12, 25);

    private final int month;
    private final int day;

    Holiday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }
}
