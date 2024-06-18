package ratelimiter;

public class ResourceRateLimiter extends RateLimiter{
    public ResourceRateLimiter(RateLimit rateLimit) {
        super(rateLimit);
    }
}
