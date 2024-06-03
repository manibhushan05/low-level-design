package ridesharingservice;

import java.util.List;
import java.util.Map;

public class RideService {
    private Map<String, Driver> drivers;
    private List<Rider> riders;
    private List<Ride> rides;

    public Ride requestRide(Rider rider, Driver driver, Location pickup, Location dropoff) {
        return new Ride(rider, driver, pickup, dropoff);
    }

    public void acceptRide(Ride ride) {
        if (ride.getStatus() == RideStatus.REQUESTED) {
            ride.setStatus(RideStatus.ACCEPTED);
            ride.getDriver().setAvailable(false);
        }
    }

    public void startRide(Ride ride) {
        ride.setStatus(RideStatus.IN_PROGRESS);
    }

    public void completeRide(Ride ride) {
        ride.setStatus(RideStatus.COMPLETED);
    }

    public void cancelRide(Ride ride) {
        ride.setStatus(RideStatus.CANCELLED);

    }
    private void notifyDrivers(Ride ride) {
        for (Driver driver : drivers.values()) {
            if (driver.isAvailable()) {
                double distance = calculateDistance(driver.getLocation(), ride.getPickupLocation());
                if (distance <= 5.0) { // Notify drivers within 5 km radius
                    // Send notification to the driver
                    System.out.println("Notifying driver: " + driver.getName()+ " about ride request: " + ride.getRideId());
                }
            }
        }
    }
    private double calculateFare(Ride ride) {
        double baseFare = 2.0;
        double perKmFare = 1.5;
        double perMinuteFare = 0.25;

        double distance = calculateDistance(ride.getPickupLocation(), ride.getDropoffLocation());
        double duration = calculateDuration(ride.getPickupLocation(), ride.getDropoffLocation());

        double fare = baseFare + (distance * perKmFare) + (duration * perMinuteFare);
        return Math.round(fare * 100.0) / 100.0; // Round to 2 decimal places
    }

    public double calculateDistance(Location source, Location Destination) {
        // Calculate the distance between two locations using a distance formula (e.g., Haversine formula)
        // For simplicity, let's assume a random distance between 1 and 20 km
        return Math.random() * 20 + 1;
    }
    private double calculateDuration(Location source, Location destination) {
        // Calculate the estimated duration between two locations based on distance and average speed
        // For simplicity, let's assume an average speed of 30 km/h
        double distance = calculateDistance(source, destination);
        return (distance / 30) * 60; // Convert hours to minutes
    }
}
