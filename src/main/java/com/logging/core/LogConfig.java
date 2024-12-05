package com.logging.core;

import com.logging.formatter.LogFormatter;
import com.logging.formatter.PlainTextFormatter;
import com.logging.output.ConsoleOutput;
import com.logging.output.LogOutput;

import java.util.ArrayList;
import java.util.List;

public class LogConfig {
    private LogLevel minimumLevel;
    private LogFormatter formatter;
    private List<LogOutput> outputs;

    private LogConfig() {
        this.minimumLevel = LogLevel.INFO;
        this.formatter = new PlainTextFormatter();
        this.outputs = new ArrayList<>();
        this.outputs.add(new ConsoleOutput());
    }

    public static Builder builder() {
        return new Builder();
    }

    public LogLevel getMinimumLevel() {
        return minimumLevel;
    }

    public LogFormatter getFormatter() {
        return formatter;
    }

    public List<LogOutput> getOutputs() {
        return outputs;
    }

    public static class Builder {
        private final LogConfig config;

        private Builder() {
            config = new LogConfig();
        }

        public Builder setMinimumLevel(LogLevel level) {
            config.minimumLevel = level;
            return this;
        }

        public Builder setFormatter(LogFormatter formatter) {
            config.formatter = formatter;
            return this;
        }

        public Builder addOutput(LogOutput output) {
            config.outputs.clear(); // Clear default outputs
            config.outputs.add(output);
            return this;
        }

        public Builder addOutputs(List<LogOutput> outputs) {
            config.outputs.clear(); // Clear default outputs
            config.outputs.addAll(outputs);
            return this;
        }

        public Builder clearOutputs() {
            config.outputs.clear();
            return this;
        }

        public LogConfig build() {
            if (config.outputs.isEmpty()) {
                config.outputs.add(new ConsoleOutput());
            }
            return config;
        }
    }
}
