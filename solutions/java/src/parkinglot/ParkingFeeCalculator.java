package parkinglot;

import parkinglot.vehicletype.VehicleType;

import java.util.Map;

public class ParkingFeeCalculator {
    private static final Map<VehicleType, Double> HOURLY_RATES = Map.of(
            VehicleType.BIKE, 10.0,
            VehicleType.CAR, 20.0,
            VehicleType.TRUCK, 30.0
    );

    public double calculateFee(ParkingTicket parkingTicket) {
        int duration = parkingTicket.getDuration();
        VehicleType vehicleType = parkingTicket.getVehicle().getVehicleType();
        double hourlyRate = HOURLY_RATES.get(vehicleType);
        return hourlyRate * duration;
    }
}
