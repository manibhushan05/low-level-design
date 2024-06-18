package ratelimiter;

public class RateLimiterDemo {
    public static void main(String[] args) {
        RateLimiterFactory rateLimiterFactory = new RateLimiterFactory();
        RateLimiterService rateLimiterService = new RateLimiterService(rateLimiterFactory);
        RateLimit serviceRateLimit = new RateLimit(2, 60); // 100 requests per minute
        RateLimit resourceRateLimit = new RateLimit(50, 60); // 50 requests per minute
        RateLimit userRateLimit = new RateLimit(10, 60); // 10 requests per minute

        String serviceName = "exampleService";
        String resourceName = "exampleResource";
        String userId = "user123";
        for(int i = 0; i < 5;i++){
            // Check service level rate limit
            if (rateLimiterService.allowServiceRequest(serviceName, serviceRateLimit)) {
                System.out.println("Service level request allowed");
            } else {
                System.out.println("Service level request not allowed");
            }
        }

        // Check resource level rate limit
        if (rateLimiterService.allowResourceRequest(resourceName, resourceRateLimit)) {
            System.out.println("Resource level request allowed");
        } else {
            System.out.println("Resource level rate limit exceeded");
        }

        // Check user level rate limit
        if (rateLimiterService.allowUserRequest(serviceName, userId, userRateLimit)) {
            System.out.println("User level request allowed");
        } else {
            System.out.println("User level rate limit exceeded");
        }
    }
}
