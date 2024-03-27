package com.hexaware.exception;

public class ReservationException extends Exception{
	
	 public ReservationException(String message) {
		 super("Reservation error: " + message);
	    }

}
