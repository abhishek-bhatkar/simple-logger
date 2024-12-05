package com.logging.formatter;

import com.logging.core.LogMessage;

public interface LogFormatter {
    String format(LogMessage logMessage);
}
