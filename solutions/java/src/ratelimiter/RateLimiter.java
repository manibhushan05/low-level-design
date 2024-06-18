package ratelimiter;

public abstract class RateLimiter {
    private RateLimit rateLimit;
    private TokenBucket tokenBucket;

    public RateLimiter(RateLimit rateLimit) {
        this.rateLimit = rateLimit;
        this.tokenBucket = new TokenBucket(rateLimit.getLimit(), rateLimit.getTimeWindow());
    }

    public boolean allowRequest(){
        return tokenBucket.allowRequest();
    }
}
