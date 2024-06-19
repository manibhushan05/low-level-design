package ratelimiter;

public class MonitoringObserver implements RateLimiterObserver{
    @Override
    public void update(String key, boolean allowed) {
        // implement logic for monitoring
    }
}
