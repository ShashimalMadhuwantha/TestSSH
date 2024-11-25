package utils;

public class Logger {

    // Logs a message to the console
    public static void log(String message) {
        System.out.println("[LOG] " + message);
    }

    // Logs a message with a custom prefix
    public static void log(String prefix, String message) {
        System.out.println("[" + prefix + "] " + message);
    }

    // Logs an error message
    public static void logError(String message) {
        System.err.println("[ERROR] " + message);
    }
}
