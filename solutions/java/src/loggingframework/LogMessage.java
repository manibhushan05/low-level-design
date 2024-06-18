package loggingframework;

public class LogMessage {
    private String message;
    private LogLevel level;
    private long timestamp;

    public LogMessage(LogLevel level, String message) {
        this.message = message;
        this.level = level;
        timestamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "[" + level + "] " + timestamp + " - " + message;
    }
}
