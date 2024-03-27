/**
 * Controller class for handling authentication of customers.
 */
package com.hexaware.Controller;

import java.util.Scanner;

import com.hexaware.exception.AuthenticationException;
import com.hexaware.model.Customer;

public class AuthenticationServiceCont {
    Customer customer;

    /**
     * Authenticates a customer based on the provided username and password.
     * @param username the username of the customer
     * @param password the password of the customer
     * @return true if authentication fails, false if authentication is successful
     * @throws AuthenticationException if there is an issue with the authentication process
     */
    public boolean authenticate(String username, String password) throws AuthenticationException {
        CustomerService cust = new CustomerService();
        customer = cust.getCustomerByUsername(username);
        if (customer != null && customer.getPassword() != null && customer.getPassword().equals(password)) {
            return false;
        } else {
            return true;
        }
    }
}