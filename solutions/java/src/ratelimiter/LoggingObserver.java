package ratelimiter;

public class LoggingObserver implements RateLimiterObserver{
    @Override
    public void update(String key, boolean allowed) {
        System.out.println("Request " + (allowed ? "allowed" : "denied") + " for key: " + key);
    }
}
