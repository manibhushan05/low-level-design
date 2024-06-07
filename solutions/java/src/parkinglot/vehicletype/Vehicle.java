package parkinglot.vehicletype;

public abstract class Vehicle {
    private final String vehicleNumber;
    private final VehicleType vehicleType;



    protected Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
