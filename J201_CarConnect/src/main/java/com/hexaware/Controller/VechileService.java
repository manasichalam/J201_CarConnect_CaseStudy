/**
 * Service class for managing Vehicle entities.
 */
package com.hexaware.Controller;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.dao.CarConnectDao;
import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.VehicleNotFoundException;
import com.hexaware.model.Vechile;

public class VechileService implements IVechileService {

    private List<Vechile> vehicles = new ArrayList<>();

    /**
     * Retrieve a vehicle by ID.
     * @param vehicleId the ID of the vehicle to retrieve
     * @return the vehicle with the specified ID, or null if not found
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    @Override
    public Vechile getVehicleById(int vehicleId) throws DatabaseConnectionException {
        for (Vechile vehicle : vehicles) {
            if (vehicle.getVid() == vehicleId) {
                return vehicle;
            }
        }
        return null;
    }

    /**
     * Retrieve a list of available vehicles.
     * @return a list of available vehicles
     */
    public List<Vechile> getAvailableVehicles() {
        List<Vechile> availableVehicles = new ArrayList<>();
        for (Vechile vehicle : vehicles) {
            if (vehicle.isAvailability()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    /**
     * Add a new vehicle.
     * @param vehicleData the vehicle data to add
     * @return true if the vehicle is successfully added, false if an exception occurs
     */
    @Override
    public boolean addVehicle(Vechile vehicleData) {
        try {
            vehicles.add(vehicleData);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Update an existing vehicle.
     * @param vehicleData the vehicle data to update
     */
    public void updateVehicle(Vechile vehicleData) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getVid() == vehicleData.getVid()) {
                vehicles.set(i, vehicleData);
                break;
            }
        }
    }

    /**
     * Remove a vehicle by ID.
     * @param vehicleId the ID of the vehicle to remove
     */
    @Override
    public void removeVehicle(int vehicleId) {
        vehicles.removeIf(vehicle -> vehicle.getVid() == vehicleId);
    }
}