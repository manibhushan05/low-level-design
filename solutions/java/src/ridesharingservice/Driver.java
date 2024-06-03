package ridesharingservice;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Driver extends User {
    private Vehicle vehicle;
    private boolean isAvailable;
   private Location location;

    public Driver(String name, String phone, Vehicle vehicle) {
        super(UUID.randomUUID().toString(), name, phone);
        this.vehicle = vehicle;
        this.isAvailable = true;
        this.location = null;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
