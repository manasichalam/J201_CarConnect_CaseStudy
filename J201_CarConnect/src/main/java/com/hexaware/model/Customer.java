package com.hexaware.model;

import java.util.Date;

import java.time.LocalDate;
import java.util.Date;

/**
 * Represents a customer entity.
 */
public class Customer {
    private int cid; 
    private String FName; 
    private String LName; 
    private String email; 
    private String phoneNumber; 
    private String address; 
    private String username; 
    private String password; 
    private String registrationDate; 

    /**
     * Constructs a Customer object with specified attributes.
     *
     * @param cid              The customer ID.
     * @param FName            The first name.
     * @param LName            The last name.
     * @param email            The email address.
     * @param phoneNumber      The phone number.
     * @param address          The address.
     * @param username         The username.
     * @param password         The password.
     * @param registrationDate The registration date.
     */
    public Customer(int cid, String FName, String LName, String email, String phoneNumber, String address,
                    String username, String password, String date) {
        super();
        this.cid = cid;
        this.FName = FName;
        this.LName = LName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.username = username;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    /**
     * Default constructor.
     */
    public Customer() {

    }

    // Getters and setters

    /**
     * Gets the customer ID.
     *
     * @return The customer ID.
     */
    public int getCid() {
        return cid;
    }

    /**
     * Sets the customer ID.
     *
     * @param cid The customer ID to set.
     */
    public void setCid(int cid) {
        this.cid = cid;
    }

    /**
     * Gets the first name.
     *
     * @return The first name.
     */
    public String getFName() {
        return FName;
    }

    /**
     * Sets the first name.
     *
     * @param fName The first name to set.
     */
    public void setFName(String fName) {
        FName = fName;
    }

    /**
     * Gets the last name.
     *
     * @return The last name.
     */
    public String getLName() {
        return LName;
    }

    /**
     * Sets the last name.
     *
     * @param lName The last name to set.
     */
    public void setLName(String lName) {
        LName = lName;
    }

    /**
     * Gets the email address.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address.
     *
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number.
     *
     * @return The phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     *
     * @param phoneNumber The phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the address.
     *
     * @return The address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address The address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the username.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the registration date.
     *
     * @return The registration date.
     */
    public String getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets the registration date.
     *
     * @param currentDate The registration date to set.
     */
    public void setRegistrationDate(String currentDate) {
        this.registrationDate = currentDate;
    }

    /**
     * Returns a string representation of the Customer object.
     *
     * @return A string representation of the Customer object.
     */
    @Override
    public String toString() {
        return "Customer [cid=" + cid + ", FName=" + FName + ", LName=" + LName + ", email=" + email
                + ", phoneNumber=" + phoneNumber + ", address=" + address + ", username=" + username + ", password="
                + password + ", registrationDate=" + registrationDate + "]";
    }
}
