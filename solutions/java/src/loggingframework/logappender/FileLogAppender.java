package loggingframework.logappender;

import loggingframework.LogMessage;

public class FileLogAppender implements LogAppender {
    @Override
    public void appendLog(LogMessage message) {
        System.out.println("[FILE]" + message);
    }
}
