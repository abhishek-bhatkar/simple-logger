package com.logging.output;

public interface LogOutput {
    void write(String formattedMessage);
    void close();
}
