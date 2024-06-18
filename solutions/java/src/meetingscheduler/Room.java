package meetingscheduler;

import java.time.LocalDateTime;

public class Room {
    private final String name;
    private LocalDateTime startTime;
    private LocalDateTime closingTime;
    private final int capacity;

    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}
