/**
 * Interface for Vehicle service operations.
 */
package com.hexaware.Controller;

import java.util.List;

import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.VehicleNotFoundException;
import com.hexaware.model.Vechile;

public interface IVechileService {

    /**
     * Retrieve a vehicle by ID.
     * @param vehicleId the ID of the vehicle to retrieve
     * @return the vehicle with the specified ID
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    Vechile getVehicleById(int vehicleId) throws DatabaseConnectionException;

    /**
     * Retrieve a list of available vehicles.
     * @return a list of available vehicles
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    List<Vechile> getAvailableVehicles() throws DatabaseConnectionException;

    /**
     * Add a new vehicle.
     * @param vehicleData the vehicle data to add
     * @return true if the vehicle is successfully added
     * @throws DatabaseConnectionException if there is an issue with the database connection
     * @throws VehicleNotFoundException if the vehicle is not found
     */
    boolean addVehicle(Vechile vehicleData) throws DatabaseConnectionException, VehicleNotFoundException;

    /**
     * Update an existing vehicle.
     * @param vehicleData the vehicle data to update
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    void updateVehicle(Vechile vehicleData) throws DatabaseConnectionException;

    /**
     * Remove a vehicle by ID.
     * @param vehicleId the ID of the vehicle to remove
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    void removeVehicle(int vehicleId) throws DatabaseConnectionException;
}