package ratelimiter;

import java.util.concurrent.atomic.AtomicInteger;

public class TokenBucketStrategy implements RateLimiterStrategy {
    private final int maxTokens;
    private final long refillInterval;
    private AtomicInteger tokens;
    private long lastRefillTimestamp;

    public TokenBucketStrategy(int maxTokens, long refillIntervalInSeconds) {
        this.maxTokens = maxTokens;
        this.refillInterval = refillIntervalInSeconds * 1000L;
        this.tokens = new AtomicInteger(maxTokens);
        this.lastRefillTimestamp = System.currentTimeMillis();
    }

    private synchronized void refill() {
        long now = System.currentTimeMillis();
        if (now > lastRefillTimestamp + refillInterval) {
            tokens.set(maxTokens);
            lastRefillTimestamp = now;
        }
    }

    @Override
    public boolean allowRequest(String key) {
        refill();
        if (tokens.get() > 0) {
            tokens.decrementAndGet();
            return true;
        }
        return false;
    }
}
