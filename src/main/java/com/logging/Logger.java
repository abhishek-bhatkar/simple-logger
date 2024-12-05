package com.logging;

import com.logging.core.LogConfig;
import com.logging.core.LogLevel;
import com.logging.core.LogMessage;
import com.logging.output.LogOutput;

public class Logger {
    private final String name;
    private final LogConfig config;

    private Logger(String name, LogConfig config) {
        this.name = name;
        this.config = config;
    }

    public static Logger getLogger(String name) {
        return new Logger(name, LogConfig.builder().build());
    }

    public static Logger getLogger(String name, LogConfig config) {
        return new Logger(name, config);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    private void log(LogLevel level, String message) {
        if (!level.isEnabled(config.getMinimumLevel())) {
            return;
        }

        LogMessage logMessage = new LogMessage(message, level, name);
        String formattedMessage = config.getFormatter().format(logMessage);

        for (LogOutput output : config.getOutputs()) {
            output.write(formattedMessage);
        }
    }
}
