package loggingframework;

import loggingframework.logappender.FileLogAppender;

public class LoggingFrameworkDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.setConfig(new LoggerConfig(new FileLogAppender(), LogLevel.INFO));
        logger.info("INFO FILE");
    }
}
