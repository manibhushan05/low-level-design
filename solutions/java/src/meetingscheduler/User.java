package meetingscheduler;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String userId;
    private List<Meeting> meetings;

    public User(String userId) {
        this.userId = userId;
        meetings = new ArrayList<>();
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void addMeetings(Meeting meeting) {
        meetings.add(meeting);
    }

    public void removeMeeting(Meeting meeting) {
        meetings.remove(meeting);
    }

    public String getUserId() {
        return userId;
    }
}
