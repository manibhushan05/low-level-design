package parkinglot;

import parkinglot.vehicletype.Vehicle;

import java.util.Date;

public class ParkingTicket {
    private static int ticketCounter = 0;

    private final int ticketNumber;

    private final Date issuedAt;

    private final Vehicle vehicle;

    private final ParkingSpot parkingSpot;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketNumber = ticketCounter++;
        this.issuedAt = new Date();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public int getDuration(){
        return (int) ((new Date().getTime()- issuedAt.getTime())/(60 * 1000));
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
