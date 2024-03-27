/**
 * Service class for managing Reservation entities.
 */
package com.hexaware.Controller;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.dao.CarConnectDao;
import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.model.Reservation;

public class ReservationService implements IReservationService {

    private List<Reservation> reservationList;

    /**
     * Constructor for ReservationService.
     * @param dao the data access object for Reservation entities
     */
    public ReservationService(CarConnectDao dao) {
        this.reservationList = new ArrayList<>();
    }

    /**
     * Retrieve a reservation by ID.
     * @param reservationId the ID of the reservation to retrieve
     * @return the reservation with the specified ID, or null if not found
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    public Reservation getReservationById(int reservationId) throws DatabaseConnectionException {
        for (Reservation reservation : reservationList) {
            if (reservation.getReservationID() == reservationId) {
                return reservation;
            }
        }
        return null;
    }

    /**
     * Retrieve reservations by customer ID.
     * @param customerId the ID of the customer to retrieve reservations for
     * @return a list of reservations associated with the specified customer ID
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    public List<Reservation> getReservationsByCustomerId(int customerId) throws DatabaseConnectionException {
        List<Reservation> customerReservations = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            if (reservation.getCid() == customerId) {
                customerReservations.add(reservation);
            }
        }
        return customerReservations;
    }

    /**
     * Create a new reservation.
     * @param reservationData the reservation data to create
     * @return true if the reservation is successfully created
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    public boolean createReservation(Reservation reservationData) throws DatabaseConnectionException {
        reservationList.add(reservationData);
        return true;
    }

    /**
     * Update an existing reservation.
     * @param reservationData the reservation data to update
     * @return true if the reservation is successfully updated, false if the reservation ID is not found
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    public boolean updateReservation(Reservation reservationData) throws DatabaseConnectionException {
        for (int i = 0; i < reservationList.size(); i++) {
            Reservation reservation = reservationList.get(i);
            if (reservation.getReservationID() == reservationData.getReservationID()) {
                reservationList.set(i, reservationData);
                return true;
            }
        }
        return false;
    }

    /**
     * Cancel a reservation by ID.
     * @param reservationId the ID of the reservation to cancel
     * @return true if the reservation is successfully canceled, false if the reservation ID is not found
     * @throws DatabaseConnectionException if there is an issue with the database connection
     */
    public boolean cancelReservation(int reservationId) throws DatabaseConnectionException {
        for (Reservation reservation : reservationList) {
            if (reservation.getReservationID() == reservationId) {
                reservationList.remove(reservation);
                return true;
            }
        }
        return false;
    }
}