package parkinglot;

import parkinglot.vehicletype.Vehicle;
import parkinglot.vehicletype.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private final String level;
    private List<ParkingSpot> parkingSpots;

    public Floor(String level, int numOfSpots, VehicleType vehicleType) {
        this.level = level;
        parkingSpots = new ArrayList<>();
        for (int i = 0; i < numOfSpots; i++) {
            parkingSpots.add(new ParkingSpot(String.format("LEVEL-%s-%s", level, i), vehicleType));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.isAvailable() && parkingSpot.getVehicleType() == vehicle.getVehicleType()) {
                parkingSpot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (!parkingSpot.isAvailable() && parkingSpot.getParkedVehicle().equals(vehicle)) {
                parkingSpot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailabilityOfSpot() {
        System.out.println("Level: " + level + " Availability");
        for (ParkingSpot spot : parkingSpots) {
            System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isAvailable() ? "Available" : "Occupied"));
        }
    }
}
