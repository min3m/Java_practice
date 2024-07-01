package oncall.model;

public enum Regex {
    COMMA(","),
    NUMBER("[^0-9]");

    private final String regex;

    Regex(String regex) {
        this.regex = regex;
    }
    public String getRegex() {
        return regex;
    }
}