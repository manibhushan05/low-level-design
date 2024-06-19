package ratelimiter;

public interface RateLimiterStrategy {
    boolean allowRequest(String key);
}
