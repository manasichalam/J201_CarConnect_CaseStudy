package com.hexaware.model;

/**
 * This class represents a Reservation for a vehicle rental.
 */
public class Reservation {
    
    private int reservationID;
    private int cid;
    private int vid;
    private String startdate;
    private String enddate;
    private double totalCost;
    private String statusof;

    /**
     * Constructs a new Reservation object with default values.
     */
    public Reservation() {
        super();
        this.reservationID = reservationID;
        this.cid = cid;
        this.vid = vid;
        this.startdate = startdate;
        this.enddate = enddate;
        this.totalCost = totalCost;
        this.statusof = statusof;
    }

    /**
     * Get the reservation ID.
     * 
     * @return The reservation ID.
     */
    public int getReservationID() {
        return reservationID;
    }

    /**
     * Set the reservation ID.
     * 
     * @param reservationID The reservation ID to set.
     */
    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    /**
     * Get the customer ID associated with the reservation.
     * 
     * @return The customer ID.
     */
    public int getCid() {
        return cid;
    }

    /**
     * Set the customer ID associated with the reservation.
     * 
     * @param cid The customer ID to set.
     */
    public void setCid(int cid) {
        this.cid = cid;
    }

    /**
     * Get the vehicle ID associated with the reservation.
     * 
     * @return The vehicle ID.
     */
    public int getVid() {
        return vid;
    }

    /**
     * Set the vehicle ID associated with the reservation.
     * 
     * @param i The vehicle ID to set.
     */
    public void setVid(int i) {
        this.vid = i;
    }

    /**
     * Get the start date of the reservation.
     * 
     * @return The start date.
     */
    public String getStartdate() {
        return startdate;
    }

    /**
     * Set the start date of the reservation.
     * 
     * @param string The start date to set.
     */
    public void setStartdate(String string) {
        this.startdate = string;
    }

    /**
     * Get the end date of the reservation.
     * 
     * @return The end date.
     */
    public String getEnddate() {
        return enddate;
    }

    /**
     * Set the end date of the reservation.
     * 
     * @param string The end date to set.
     */
    public void setEnddate(String string) {
        this.enddate = string;
    }

    /**
     * Get the total cost of the reservation.
     * 
     * @return The total cost.
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Set the total cost of the reservation.
     * 
     * @param totalCost The total cost to set.
     */
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Get the status of the reservation.
     * 
     * @return The status.
     */
    public String getStatusof() {
        return statusof;
    }

    /**
     * Set the status of the reservation.
     * 
     * @param statusof The status to set.
     */
    public void setStatusof(String statusof) {
        this.statusof = statusof;
    }

    /**
     * Returns a string representation of the Reservation object.
     * 
     * @return A string representation of the Reservation.
     */
    @Override
    public String toString() {
        return "Reservation [reservationID=" + reservationID + ", cid=" + cid + ", vid=" + vid + ", startdate="
                + startdate + ", enddate=" + enddate + ", totalCost=" + totalCost + ", statusof=" + statusof + "]";
    }   
}
