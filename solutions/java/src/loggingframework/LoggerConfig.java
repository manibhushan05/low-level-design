package loggingframework;

import loggingframework.logappender.LogAppender;

public class LoggerConfig {
    private final LogAppender logAppender;
    private final LogLevel level;

    public LoggerConfig(LogAppender logAppender, LogLevel level) {
        this.logAppender = logAppender;
        this.level = level;
    }

    public LogLevel getLevel() {
        return level;
    }

    public LogAppender getLogAppender() {
        return logAppender;
    }
}
