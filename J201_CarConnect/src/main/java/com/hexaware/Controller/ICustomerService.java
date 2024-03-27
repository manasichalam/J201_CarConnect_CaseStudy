/**
 * Interface for Customer service operations.
 */
package com.hexaware.Controller;

import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.model.Customer;

public interface ICustomerService {

    /**
     * Retrieve a customer by ID.
     * @param customerId the ID of the customer to retrieve
     * @return the customer with the specified ID
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    Customer getCustomerById(int customerId) throws DatabaseConnectionException;

    /**
     * Retrieve a customer by username.
     * @param username the username of the customer to retrieve
     * @return the customer with the specified username
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    Customer getCustomerByUsername(String username) throws DatabaseConnectionException;

    /**
     * Register a new customer.
     * @param customerData the customer data to register
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    void registerCustomer(Customer customerData) throws DatabaseConnectionException;

    /**
     * Update an existing customer.
     * @param customerData the customer data to update
     * @return true if the customer is successfully updated
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    boolean updateCustomer(Customer customerData) throws DatabaseConnectionException;

    /**
     * Delete a customer by ID.
     * @param customerId the ID of the customer to delete
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    void deleteCustomer(int customerId) throws DatabaseConnectionException;
}