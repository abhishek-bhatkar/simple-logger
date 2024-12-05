package com.logging.formatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.logging.core.LogLevel;
import com.logging.core.LogMessage;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsonFormatterTest {

    @Test
    public void testFormat() throws Exception {
        JsonFormatter formatter = new JsonFormatter();
        LogMessage logMessage = new LogMessage("This is a test message", LogLevel.INFO, "TestLogger");
        String formattedMessage = formatter.format(logMessage);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        LogMessage result = objectMapper.readValue(formattedMessage, LogMessage.class);

        assertEquals(LogLevel.INFO, result.getLevel());
        assertEquals("TestLogger", result.getLoggerName());
        assertEquals("This is a test message", result.getMessage());
    }
}
