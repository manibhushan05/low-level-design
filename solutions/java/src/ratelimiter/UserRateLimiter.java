package ratelimiter;

public class UserRateLimiter extends RateLimiter{
    public UserRateLimiter(RateLimit rateLimit) {
        super(rateLimit);
    }
}
