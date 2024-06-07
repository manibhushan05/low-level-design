package parkinglot;

import parkinglot.vehicletype.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<Floor> floors;

    public ParkingLot() {
        this.floors = new ArrayList<>();
    }


    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Floor floor) {
        floors.add(floor);
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(Floor floor: floors){
            if (floor.parkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle){
        for(Floor floor: floors){
            if(floor.unParkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public void displaySpot(){
       floors.forEach(Floor::displayAvailabilityOfSpot);
    }
}
