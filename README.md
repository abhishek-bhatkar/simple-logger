# Simple Logger

Simple Logger is a lightweight, extensible Java logging framework designed to provide flexible and configurable logging capabilities for Java applications. It supports multiple output destinations and customizable log formats.

## Features
- **Log Levels**: Supports DEBUG, INFO, WARN, ERROR
- **Formatters**: Includes PlainTextFormatter and JsonFormatter
- **Outputs**: Logs can be output to console and/or files
- **Configuration**: Easily configurable using a builder pattern
- **Thread-Safe**: File operations are thread-safe
- **Java 8+ Compatibility**: Designed to work with Java 8 and higher

## Getting Started

### Prerequisites
- Java 8 or higher
- Maven for building the project

### Installation
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd simple-logger
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

## Usage

### Basic Usage
Here's a simple example of how to use Simple Logger:

```java
import com.logging.Logger;
import com.logging.core.LogLevel;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("MyLogger");
        logger.info("This is an info message");
        logger.error("This is an error message");
    }
}
```

### Advanced Configuration
You can configure the logger with different formatters and outputs:

```java
import com.logging.Logger;
import com.logging.core.LogConfig;
import com.logging.core.LogLevel;
import com.logging.formatter.JsonFormatter;
import com.logging.output.FileOutput;

public class Main {
    public static void main(String[] args) {
        LogConfig config = LogConfig.builder()
                .setMinimumLevel(LogLevel.DEBUG)
                .setFormatter(new JsonFormatter())
                .addOutput(new FileOutput("logs/application.log"))
                .build();

        Logger logger = Logger.getLogger("ConfiguredLogger", config);
        logger.debug("This is a debug message");
    }
}
```

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
