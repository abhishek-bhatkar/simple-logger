package com.logging.core;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class LogMessage {
    private final String message;
    private final LogLevel level;
    private final Instant timestamp;
    private final Map<String, Object> metadata;
    private final String loggerName;

    // Default constructor for deserialization
    public LogMessage() {
        this.message = "";
        this.level = LogLevel.INFO;
        this.timestamp = Instant.now();
        this.metadata = new HashMap<>();
        this.loggerName = "";
    }

    public LogMessage(String message, LogLevel level, String loggerName) {
        this.message = message;
        this.level = level;
        this.timestamp = Instant.now();
        this.metadata = new HashMap<>();
        this.loggerName = loggerName;
    }

    public String getMessage() {
        return message;
    }

    public LogLevel getLevel() {
        return level;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void addMetadata(String key, Object value) {
        metadata.put(key, value);
    }
}
