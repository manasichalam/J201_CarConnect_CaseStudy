package com.hexaware.exception;

/**
 * Exception thrown when a customer is not found.
 */
public class CustomerNotFoundException extends Exception {
    
    /**
     * Constructs a CustomerNotFoundException with the specified detail message.
     * 
     * @param message The detail message.
     */
    public CustomerNotFoundException(String message) {
        super("Customer not found: " + message);
    }
}
