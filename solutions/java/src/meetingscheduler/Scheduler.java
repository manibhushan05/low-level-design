package meetingscheduler;

import java.util.List;

public class Scheduler {

    public boolean scheduleMeeting(List<User> participants) {
        return true;
    }

    public boolean cancelMeeting(Meeting meeting) {
        return true;
    }

    public boolean rescheduleMeeting(Meeting meeting) {
        return false;
    }

    public List<Meeting> getMeetingsByUser(User user){
        return user.getMeetings();
    }
}
