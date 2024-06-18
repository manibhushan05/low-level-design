package loggingframework.logappender;

import loggingframework.LogMessage;

public class ConsoleLogAppender implements LogAppender {
    @Override
    public void appendLog(LogMessage message) {
        System.out.println("[CONSOLE] " + message);
    }
}
