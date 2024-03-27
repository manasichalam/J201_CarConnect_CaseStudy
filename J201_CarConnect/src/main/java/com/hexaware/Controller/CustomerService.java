/**
 * Service class for managing Customer entities.
 */
package com.hexaware.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.model.Customer;

public class CustomerService implements ICustomerService {
    
    private List<Customer> customers = new ArrayList<>();

    /**
     * Retrieve a customer by ID.
     * @param customerId the ID of the customer to retrieve
     * @return the customer with the specified ID, or null if not found
     */
    @Override
    public Customer getCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCid() == customerId) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Retrieve a customer by username.
     * @param username the username of the customer to retrieve
     * @return the customer with the specified username, or null if not found
     */
    @Override
    public Customer getCustomerByUsername(String username) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Register a new customer.
     * @param customer the customer to register
     */
    @Override
    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    /**
     * Update an existing customer.
     * @param customer the customer data to update
     * @return true if the customer is successfully updated, false if the customer ID is not found
     */
    @Override
    public boolean updateCustomer(Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCid() == customer.getCid()) {
                customers.set(i, customer);
                return true;
            }
        }
        return false;
    }

    /**
     * Delete a customer by ID.
     * @param customerId the ID of the customer to delete
     */
    @Override
    public void deleteCustomer(int customerId) {
        customers.removeIf(customer -> customer.getCid() == customerId);
    }
}