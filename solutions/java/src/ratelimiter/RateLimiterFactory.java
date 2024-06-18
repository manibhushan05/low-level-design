package ratelimiter;

import java.util.HashMap;
import java.util.Map;

public class RateLimiterFactory {
    private Map<String, ServiceRateLimiter> serviceRateLimiters;
    private Map<String, ResourceRateLimiter> resourceRateLimiters;
    private Map<String, Map<String, UserRateLimiter>> userRateLimiters = new HashMap<>();

    public RateLimiterFactory() {
        serviceRateLimiters = new HashMap<>();
        resourceRateLimiters = new HashMap<>();
        userRateLimiters = new HashMap<>();
    }

    public ServiceRateLimiter getServiceRateLimiters(String serviceName, RateLimit rateLimit) {
        return serviceRateLimiters.computeIfAbsent(serviceName, k -> new ServiceRateLimiter(rateLimit));
    }

    public ResourceRateLimiter getResourceRateLimiters(String serviceName, RateLimit rateLimit) {
        return resourceRateLimiters.computeIfAbsent(serviceName, k -> new ResourceRateLimiter(rateLimit));
    }

    public UserRateLimiter getUserRateLimiter(String serviceName, String userId, RateLimit rateLimit) {
        userRateLimiters.putIfAbsent(serviceName, new HashMap<>());
        Map<String, UserRateLimiter> userLimiters = userRateLimiters.get(serviceName);
        return userLimiters.computeIfAbsent(userId, k -> new UserRateLimiter(rateLimit));
    }

}
