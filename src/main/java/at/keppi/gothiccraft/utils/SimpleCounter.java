package at.keppi.gothiccraft.utils;

public class SimpleCounter {
    public static final int DEFAULT_LIMIT = 5;

    public String name;

    private int limit;
    private int count = 0;

    public SimpleCounter(String name) {
        this(name, DEFAULT_LIMIT);
    }

    public SimpleCounter(String name, int limit) {
        this.name = name;
        this.limit = limit;
    }

    public int count() {
        this.count++;
        return this.count;
    }

    public boolean isLimitReached() {
        return this.count >= this.limit;
    }
}
