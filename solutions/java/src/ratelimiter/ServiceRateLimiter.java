package ratelimiter;

public class ServiceRateLimiter extends RateLimiter{
    public ServiceRateLimiter(RateLimit rateLimit) {
        super(rateLimit);
    }
}
