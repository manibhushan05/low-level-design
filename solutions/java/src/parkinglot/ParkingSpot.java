package parkinglot;

import parkinglot.vehicletype.Vehicle;
import parkinglot.vehicletype.VehicleType;

public class ParkingSpot {
    private final String spotNumber;

    private final VehicleType vehicleType;

    private Vehicle parkedVehicle;

    public ParkingSpot(String spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = VehicleType.CAR;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if (isAvailable() && vehicle.getVehicleType() == vehicleType) {
            parkedVehicle = vehicle;
        } else {
            throw new IllegalArgumentException("Invalid parking spot");
        }
    }

    public synchronized void unparkVehicle() {
        parkedVehicle = null;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getSpotNumber() {
        return spotNumber;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
