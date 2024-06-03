package ridesharingservice;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Rider extends User {
    private final List<Ride> rideHistory;

    public Rider(String name, String phone) {
        super(UUID.randomUUID().toString(), name, phone);
        this.rideHistory = new ArrayList<>();
    }

    public void addRide(Ride ride) {
        rideHistory.add(ride);
    }

    public List<Ride> getRideHistory() {
        return rideHistory;
    }
}
