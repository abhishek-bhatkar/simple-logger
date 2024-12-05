package com.logging.example;

import com.logging.Logger;
import com.logging.core.LogConfig;
import com.logging.core.LogLevel;
import com.logging.formatter.JsonFormatter;
import com.logging.output.FileOutput;

public class LoggingExample {
    public static void main(String[] args) {
        try {
            // Example 1: Simple logger with default configuration
            Logger defaultLogger = Logger.getLogger("DefaultLogger");
            defaultLogger.info("This is an info message");
            defaultLogger.error("This is an error message");

            // Example 2: Configured logger with JSON formatting and file output
            LogConfig config = LogConfig.builder()
                    .setMinimumLevel(LogLevel.DEBUG)
                    .setFormatter(new JsonFormatter())
                    .addOutput(new FileOutput("logs/application.log"))
                    .build();

            Logger configuredLogger = Logger.getLogger("ConfiguredLogger", config);
            configuredLogger.debug("This is a debug message");
            configuredLogger.info("This is an info message");
            configuredLogger.warn("This is a warning message");
            configuredLogger.error("This is an error message");

        } catch (Exception e) {
            System.err.println("Error in logging example: " + e.getMessage());
        }
    }
}
