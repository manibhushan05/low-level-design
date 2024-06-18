package ratelimiter;

public class RateLimit {
    private int limit;
    private int timeWindow;

    public RateLimit(int limit, int timeWindow) {
        this.limit = limit;
        this.timeWindow = timeWindow;
    }

    public int getTimeWindow() {
        return timeWindow;
    }

    public int getLimit() {
        return limit;
    }
}
