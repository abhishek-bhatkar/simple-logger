package com.logging.output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class FileOutput implements LogOutput {
    private final BufferedWriter writer;

    public FileOutput(Path logFile) throws IOException {
        this.writer = new BufferedWriter(new FileWriter(logFile.toFile(), true));
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
