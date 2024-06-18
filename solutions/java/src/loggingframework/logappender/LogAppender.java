package loggingframework.logappender;

import loggingframework.LogMessage;

public interface LogAppender {
    public void appendLog(LogMessage message);
}
