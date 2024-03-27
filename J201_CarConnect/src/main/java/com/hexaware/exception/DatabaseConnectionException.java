package com.hexaware.exception;

/**
 * Exception class to handle database connection failures.
 */
public class DatabaseConnectionException extends Exception {
    
    /**
     * Constructs a new DatabaseConnectionException with the specified detail message.
     * @param message The detail message.
     */
    public DatabaseConnectionException(String message) {
        super("Database connection failed: " + message);
    }
}
