package ratelimiter;

import java.util.ArrayList;
import java.util.List;

public class RateLimiterSubject {
    private List<RateLimiterObserver> rateLimiterObservers;

    public RateLimiterSubject() {
        rateLimiterObservers = new ArrayList<>();
    }

    public void addObserver(RateLimiterObserver rateLimiterObserver) {
        rateLimiterObservers.add(rateLimiterObserver);
    }

    public void removeObserver(RateLimiterObserver observer) {
        rateLimiterObservers.remove(observer);
    }

    public void notifyObserver(String key, boolean allowed) {
        for (RateLimiterObserver observer : rateLimiterObservers) {
            observer.update(key, allowed);
        }
    }
}
