package meetingscheduler;

import java.time.LocalDateTime;
import java.util.List;

public class Meeting {
    private String meetingId;
    private String title;
    private Room room;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<User> participant;
}
