package ratelimiter;

public class RateLimiterService {
    private RateLimiterFactory rateLimiterFactory;

    public RateLimiterService(RateLimiterFactory rateLimiterFactory) {
        this.rateLimiterFactory = rateLimiterFactory;
    }
    public boolean allowServiceRequest(String serviceName, RateLimit rateLimit) {
        ServiceRateLimiter rateLimiter = rateLimiterFactory.getServiceRateLimiters(serviceName, rateLimit);
        return rateLimiter.allowRequest();
    }

    public boolean allowResourceRequest(String resourceName, RateLimit rateLimit) {
        ResourceRateLimiter rateLimiter = rateLimiterFactory.getResourceRateLimiters(resourceName, rateLimit);
        return rateLimiter.allowRequest();
    }

    public boolean allowUserRequest(String serviceName, String userId, RateLimit rateLimit) {
        UserRateLimiter rateLimiter = rateLimiterFactory.getUserRateLimiter(serviceName, userId, rateLimit);
        return rateLimiter.allowRequest();
    }
}
