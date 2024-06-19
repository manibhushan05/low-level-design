package ratelimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LeakyBucketStrategy implements RateLimiterStrategy {
    private final int capacity;
    private final long leakRateInMillis;
    private final ConcurrentMap<String, Bucket> buckets;

    public LeakyBucketStrategy(int capacity, long leakRateInMillis) {
        this.capacity = capacity;
        this.leakRateInMillis = leakRateInMillis;
        this.buckets = new ConcurrentHashMap<>();
    }

    @Override
    public boolean allowRequest(String key) {
        Bucket bucket = buckets.computeIfAbsent(key, k -> new Bucket(capacity, leakRateInMillis));
        return bucket.allowRequest();
    }

    private static class Bucket {
        private final int capacity;
        private final long leakRateInMillis;
        private final AtomicInteger water;
        private long lastLeakTime;

        public Bucket(int capacity, long leakRateInMillis) {
            this.capacity = capacity;
            this.leakRateInMillis = leakRateInMillis;
            this.water = new AtomicInteger(0);
            this.lastLeakTime = System.currentTimeMillis();
        }

        public synchronized boolean allowRequest() {
            leak();
            if (water.get() < capacity) {
                water.incrementAndGet();
                return true;
            } else {
                return false;
            }
        }

        private void leak() {
            long currentTime = System.currentTimeMillis();
            long timePassed = currentTime - lastLeakTime;
            int leaks = (int) (timePassed / leakRateInMillis);
            if (leaks > 0) {
                int newWaterLevel = Math.max(0, water.get() - leaks);
                water.set(newWaterLevel);
                lastLeakTime = currentTime;
            }
        }
    }
}
