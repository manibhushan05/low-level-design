package loggingframework;

import loggingframework.logappender.ConsoleLogAppender;
import loggingframework.logappender.LogAppender;

public class Logger {
    private static final Logger instance = new Logger();
    private  LoggerConfig config;

    private Logger() {
        config = new LoggerConfig(new ConsoleLogAppender(), LogLevel.INFO);
    }

    public static Logger getInstance() {
        return instance;
    }

    public void setConfig(LoggerConfig config){
        this.config= config;
    }

    private void log(LogLevel level, String message) {
        if (level.ordinal() >= config.getLevel().ordinal()) {
            LogMessage logMessage = new LogMessage(level, message);
            config.getLogAppender().appendLog(logMessage);
        }
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }
}
