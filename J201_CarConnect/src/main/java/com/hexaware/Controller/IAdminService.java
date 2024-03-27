/**
 * Interface for Admin service operations.
 */
package com.hexaware.Controller;

import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.model.Admint;

public interface IAdminService {

    /**
     * Retrieve an Admin by ID.
     * @param adminId the ID of the Admin to retrieve
     * @return the Admin with the specified ID
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    Admint getAdminById(int adminId) throws DatabaseConnectionException;

    /**
     * Retrieve an Admin by username.
     * @param username the username of the Admin to retrieve
     * @return the Admin with the specified username
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    Admint getAdminByUsername(String username) throws DatabaseConnectionException;

    /**
     * Register a new Admin.
     * @param adminData the Admin data to register
     * @return true if the Admin is successfully registered
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    boolean registerAdmin(Admint adminData) throws DatabaseConnectionException;

    /**
     * Update an existing Admin.
     * @param adminData the Admin data to update
     * @return true if the Admin is successfully updated
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    boolean updateAdmin(Admint adminData) throws DatabaseConnectionException;

    /**
     * Delete an Admin by ID.
     * @param adminId the ID of the Admin to delete
     * @return true if the Admin is successfully deleted
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    boolean deleteAdmin(int adminId) throws DatabaseConnectionException;
}