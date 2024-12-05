package com.logging.core;

import org.junit.Test;

import static org.junit.Assert.*;

public class LogLevelTest {

    @Test
    public void testLogLevelOrder() {
        assertTrue(LogLevel.DEBUG.ordinal() < LogLevel.INFO.ordinal());
        assertTrue(LogLevel.INFO.ordinal() < LogLevel.WARN.ordinal());
        assertTrue(LogLevel.WARN.ordinal() < LogLevel.ERROR.ordinal());
    }

    @Test
    public void testLogLevelNames() {
        assertEquals("DEBUG", LogLevel.DEBUG.name());
        assertEquals("INFO", LogLevel.INFO.name());
        assertEquals("WARN", LogLevel.WARN.name());
        assertEquals("ERROR", LogLevel.ERROR.name());
    }

    // Additional tests for any custom methods in LogLevel
}
