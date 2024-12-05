package com.logging.core;

import com.logging.formatter.PlainTextFormatter;
import com.logging.output.ConsoleOutput;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LogConfigTest {
    private LogConfig config;

    @Before
    public void setUp() {
        config = LogConfig.builder()
                .setMinimumLevel(LogLevel.INFO)
                .setFormatter(new PlainTextFormatter())
                .addOutput(new ConsoleOutput())
                .build();
    }

    @Test
    public void testMinimumLogLevel() {
        assertEquals(LogLevel.INFO, config.getMinimumLevel());
    }

    @Test
    public void testFormatter() {
        assertTrue(config.getFormatter() instanceof PlainTextFormatter);
    }

    @Test
    public void testOutputs() {
        assertEquals(1, config.getOutputs().size());
        assertTrue(config.getOutputs().get(0) instanceof ConsoleOutput);
    }

    // Additional tests for other configuration options
}
