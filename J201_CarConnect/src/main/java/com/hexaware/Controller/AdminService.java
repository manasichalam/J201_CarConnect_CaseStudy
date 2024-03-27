/**
 * Service class for managing Admin entities.
 */
package com.hexaware.Controller;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.dao.CarConnectDao;
import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.model.Admint;

public class AdminService implements IAdminService {

    private List<Admint> adminList;

    /**
     * Constructor for AdminService.
     * @param dao the data access object for Admin entities
     */
    public AdminService(CarConnectDao dao) {
        this.adminList = new ArrayList<>();
    }

    /**
     * Retrieve an Admin by ID.
     * @param adminId the ID of the Admin to retrieve
     * @return the Admin with the specified ID, or null if not found
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    public Admint getAdminById(int adminId) throws DatabaseConnectionException {
        for (Admint admin : adminList) {
            if (admin.getAdminid() == adminId) {
                return admin;
            }
        }
        return null;
    }

    /**
     * Retrieve an Admin by username.
     * @param username the username of the Admin to retrieve
     * @return the Admin with the specified username, or null if not found
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    public Admint getAdminByUsername(String username) throws DatabaseConnectionException {
        for (Admint admin : adminList) {
            if (admin.getUsername1().equals(username)) {
                return admin;
            }
        }
        return null;
    }

    /**
     * Register a new Admin.
     * @param adminData the Admin data to register
     * @return true if the Admin is successfully registered, false if the username already exists
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    public boolean registerAdmin(Admint adminData) throws DatabaseConnectionException {
        if (getAdminByUsername(adminData.getUsername1()) != null) {
            return false;
        }
        adminList.add(adminData);
        return true;
    }

    /**
     * Update an existing Admin.
     * @param adminData the Admin data to update
     * @return true if the Admin is successfully updated, false if the Admin ID is not found
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    public boolean updateAdmin(Admint adminData) throws DatabaseConnectionException {
        for (int i = 0; i < adminList.size(); i++) {
            Admint admin = adminList.get(i);
            if (admin.getAdminid() == adminData.getAdminid()) {
                adminList.set(i, adminData);
                return true;
            }
        }
        return false;
    }

    /**
     * Delete an Admin by ID.
     * @param adminId the ID of the Admin to delete
     * @return true if the Admin is successfully deleted, false if the Admin ID is not found
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    public boolean deleteAdmin(int adminId) throws DatabaseConnectionException {
        for (Admint admin : adminList) {
            if (admin.getAdminid() == adminId) {
                adminList.remove(admin);
                return true;
            }
        }
        return false;
    }
}