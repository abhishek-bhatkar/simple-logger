package com.logging.formatter;

import com.logging.core.LogMessage;
import java.time.format.DateTimeFormatter;

public class PlainTextFormatter implements LogFormatter {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_INSTANT;

    @Override
    public String format(LogMessage logMessage) {
        StringBuilder sb = new StringBuilder();
        sb.append(DATE_FORMATTER.format(logMessage.getTimestamp()))
          .append(" [").append(logMessage.getLevel()).append("] ")
          .append("[").append(logMessage.getLoggerName()).append("] ")
          .append(logMessage.getMessage());

        if (!logMessage.getMetadata().isEmpty()) {
            sb.append(" | Metadata: ").append(logMessage.getMetadata());
        }

        return sb.toString();
    }
}
