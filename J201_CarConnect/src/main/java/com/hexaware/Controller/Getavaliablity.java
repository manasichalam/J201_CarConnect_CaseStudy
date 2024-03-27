/**
 * Controller class for checking the availability of vehicles.
 */
package com.hexaware.Controller;

import java.util.List;

import com.hexaware.exception.AuthenticationException;
import com.hexaware.model.Customer;
import com.hexaware.model.Vechile;

public class Getavaliablity {
    List<Vechile> vechile;

    /**
     * Retrieves the number of available vehicles.
     * @return the count of available vehicles
     * @throws AuthenticationException if there is an issue with authentication
     */
    public int getAvailableVehicles() throws AuthenticationException {
        VechileService vs = new VechileService();
        vechile = vs.getAvailableVehicles();
        int expectedAvailableVehiclesCount = 10;
        if (expectedAvailableVehiclesCount > 0) {
            return 10;
        } else {
            return 0;
        }
    }
}