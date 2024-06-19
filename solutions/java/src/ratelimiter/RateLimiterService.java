package ratelimiter;

public class RateLimiterService extends RateLimiterSubject{
    private static RateLimiterService instance;
    private RateLimiterStrategy strategy;

    private RateLimiterService() {}

    public static RateLimiterService getInstance() {
        if (instance == null) {
            synchronized (RateLimiterService.class) {
                if (instance == null) {
                    instance = new RateLimiterService();
                }
            }
        }
        return instance;
    }

    public void setStrategy(RateLimiterStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean allowRequest(String key) {
        if (strategy == null) {
            throw new IllegalStateException("RateLimiterStrategy not set");
        }
        return strategy.allowRequest(key);
    }

}
