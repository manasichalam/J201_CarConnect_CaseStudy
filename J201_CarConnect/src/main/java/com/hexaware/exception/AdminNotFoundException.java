package com.hexaware.exception;

/**
 * Exception thrown when an admin is not found.
 */
public class AdminNotFoundException extends Exception {
    
    /**
     * Constructs an AdminNotFoundException with the specified detail message.
     * 
     * @param message The detail message.
     */
    public AdminNotFoundException(String message) {
        super("Admin not found: " + message);
    }
}
