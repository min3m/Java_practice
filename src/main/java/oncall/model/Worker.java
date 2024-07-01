package oncall.model;

public class Worker {
    private final String name;

    Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Worker of(String name) {
        return new Worker(name);
    }
}
