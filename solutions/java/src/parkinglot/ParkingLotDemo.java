package parkinglot;

import parkinglot.vehicletype.*;

public class ParkingLotDemo {
    public static void run() {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Floor("1", 5, VehicleType.TRUCK));
        parkingLot.addLevel(new Floor("2", 5, VehicleType.CAR));

        Vehicle car = new Car("ABC123");
        Vehicle truck = new Truck("XYZ789");
        Vehicle motorcycle = new Bike("M1234");

        // Park vehicles
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(motorcycle);

        // Display availability
        parkingLot.displaySpot();
        System.out.println("-------------------");
        // Unpark vehicle
        parkingLot.unParkVehicle(motorcycle);

        // Display updated availability
        parkingLot.displaySpot();
    }
}
