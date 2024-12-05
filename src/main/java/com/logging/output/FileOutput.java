package com.logging.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements LogOutput {
    private final BufferedWriter writer;

    public FileOutput(String logFilePath) throws IOException {
        File logFile = new File(logFilePath);
        // Create parent directories if they don't exist
        if (logFile.getParentFile() != null) {
            logFile.getParentFile().mkdirs();
        }
        this.writer = new BufferedWriter(new FileWriter(logFile, true));
    }

    @Override
    public void write(String formattedMessage) {
        try {
            writer.write(formattedMessage);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            System.err.println("Failed to close log file: " + e.getMessage());
        }
    }
}
