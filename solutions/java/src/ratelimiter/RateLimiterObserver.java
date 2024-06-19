package ratelimiter;

public interface RateLimiterObserver {
    public void update(String key, boolean allowed);
}
