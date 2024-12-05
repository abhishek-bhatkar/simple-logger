package com.logging;

import com.logging.core.LogConfig;
import com.logging.core.LogLevel;
import com.logging.formatter.PlainTextFormatter;
import com.logging.output.ConsoleOutput;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoggerTest {
    private Logger logger;
    private LogConfig config;

    @Before
    public void setUp() {
        config = LogConfig.builder()
                .setMinimumLevel(LogLevel.DEBUG)
                .setFormatter(new PlainTextFormatter())
                .addOutput(new ConsoleOutput())
                .build();
        logger = Logger.getLogger("TestLogger", config);
    }

    @Test
    public void testInfoLogging() {
        // Capture console output
        // Test if INFO level logs are being processed correctly
        logger.info("This is an info message");
        // Add assertions to verify the behavior
    }

    @Test
    public void testErrorLogging() {
        // Capture console output
        // Test if ERROR level logs are being processed correctly
        logger.error("This is an error message");
        // Add assertions to verify the behavior
    }

    // Additional tests for other log levels and configurations
}
