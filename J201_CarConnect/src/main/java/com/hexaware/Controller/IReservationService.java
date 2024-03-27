/**
 * Interface for Reservation service operations.
 */
package com.hexaware.Controller;

import java.util.List;

import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.model.Reservation;

public interface IReservationService {

    /**
     * Retrieve a reservation by ID.
     * @param reservationId the ID of the reservation to retrieve
     * @return the reservation with the specified ID
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    Reservation getReservationById(int reservationId) throws DatabaseConnectionException;

    /**
     * Retrieve reservations by customer ID.
     * @param customerId the ID of the customer to retrieve reservations for
     * @return a list of reservations associated with the specified customer ID
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    List<Reservation> getReservationsByCustomerId(int customerId) throws DatabaseConnectionException;

    /**
     * Create a new reservation.
     * @param reservationData the reservation data to create
     * @return true if the reservation is successfully created
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    boolean createReservation(Reservation reservationData) throws DatabaseConnectionException;

    /**
     * Update an existing reservation.
     * @param reservationData the reservation data to update
     * @return true if the reservation is successfully updated
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    boolean updateReservation(Reservation reservationData) throws DatabaseConnectionException;

    /**
     * Cancel a reservation by ID.
     * @param reservationId the ID of the reservation to cancel
     * @return true if the reservation is successfully canceled
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    boolean cancelReservation(int reservationId) throws DatabaseConnectionException;
}