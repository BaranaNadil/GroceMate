package model;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.ConsoleHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;

public class POSLogger {

    private static Logger logger = Logger.getLogger(POSLogger.class.getName());

    public static Logger getLogger() {
        try {
            // Create a FileHandler to store the logs in a file
            FileHandler fileHandler = new FileHandler("pos_system.log", true); // Append mode
            fileHandler.setFormatter(new SimpleFormatter()); // Simple text format

            // Optional: Create a ConsoleHandler for outputting to the console
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new SimpleFormatter());

            // Set the logging level (you can adjust to Level.SEVERE, Level.WARNING, etc.)
            logger.setLevel(Level.ALL);

            // Add handlers to the logger
            logger.addHandler(fileHandler);
            logger.addHandler(consoleHandler);

            // Avoid logging from parent handlers (optional)
            logger.setUseParentHandlers(false);

        } catch (Exception e) {
            System.err.println("Failed to initialize logger: " + e.getMessage());
        }
        return logger;
    }

    // Example log usage
    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logWarning(String message) {
        logger.warning(message);
    }

    public static void logError(String message) {
        logger.severe(message);
    }

}
