package com.logging.output;

public class ConsoleOutput implements LogOutput {
    @Override
    public void write(String formattedMessage) {
        System.out.println(formattedMessage);
    }

    @Override
    public void close() {
        // No resources to close for console output
    }
}
