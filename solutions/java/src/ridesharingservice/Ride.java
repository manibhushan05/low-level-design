package ridesharingservice;

import java.util.UUID;

public class Ride {
    private final String rideId;
    private final Rider rider;
    private final Driver driver;
    private final Location pickupLocation;
    private final Location dropoffLocation;
    private RideStatus status;

    public Ride(Rider rider, Driver driver, Location pickupLocation, Location dropoffLocation) {
        this.rideId = UUID.randomUUID().toString();
        this.rider = rider;
        this.driver = driver;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.status = RideStatus.REQUESTED;
    }

    public Driver getDriver() {
        return driver;
    }

    public Location getDropoffLocation() {
        return dropoffLocation;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public Rider getRider() {
        return rider;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public String getRideId() {
        return rideId;
    }
}
