package com.logging.formatter;

import com.logging.core.LogLevel;
import com.logging.core.LogMessage;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlainTextFormatterTest {

    @Test
    public void testFormat() {
        PlainTextFormatter formatter = new PlainTextFormatter();
        LogMessage logMessage = new LogMessage("This is a test message", LogLevel.INFO, "TestLogger");
        String formattedMessage = formatter.format(logMessage);

        assertTrue(formattedMessage.contains("INFO"));
        assertTrue(formattedMessage.contains("TestLogger"));
        assertTrue(formattedMessage.contains("This is a test message"));
    }
}
