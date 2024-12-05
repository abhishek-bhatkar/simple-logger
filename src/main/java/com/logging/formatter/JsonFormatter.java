package com.logging.formatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logging.core.LogMessage;
import java.util.HashMap;
import java.util.Map;

public class JsonFormatter implements LogFormatter {
    private final ObjectMapper objectMapper;

    public JsonFormatter() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public String format(LogMessage logMessage) {
        try {
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("timestamp", logMessage.getTimestamp().toString());
            jsonMap.put("level", logMessage.getLevel().toString());
            jsonMap.put("logger", logMessage.getLoggerName());
            jsonMap.put("message", logMessage.getMessage());
            jsonMap.put("metadata", logMessage.getMetadata());

            return objectMapper.writeValueAsString(jsonMap);
        } catch (Exception e) {
            return String.format("{\"error\":\"Failed to format message: %s\"}", e.getMessage());
        }
    }
}
