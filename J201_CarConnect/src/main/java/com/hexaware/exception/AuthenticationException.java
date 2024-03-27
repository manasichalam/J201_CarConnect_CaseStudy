package com.hexaware.exception;

/**
 * Exception thrown when authentication fails.
 */
public class AuthenticationException extends Exception {
    
    /**
     * Constructs an AuthenticationException with the specified detail message.
     * 
     * @param message The detail message.
     */
    public AuthenticationException(String message) {
        super("Authentication failed: " + message);
    }
}
