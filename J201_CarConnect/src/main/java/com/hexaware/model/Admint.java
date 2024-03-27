package com.hexaware.model;

import java.util.Date;

/**
 * This class represents an Administrator in the system.
 */
public class Admint {
    
    private int adminid;
    private String fName;
    private String lName;
    private String email;
    private String phonenum;
    private String username1;
    private String password1;
    private String roles;
    private Date joindate;

    /**
     * Constructs a new Admint object with default values.
     */
    public Admint() {
        super();
        this.adminid = adminid;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phonenum = phonenum;
        this.username1 = username1;
        this.password1 = password1;
        this.roles = roles;
        this.joindate = joindate;
    }
    
    /**
     * Get the administrator ID.
     * 
     * @return The administrator ID.
     */
    public int getAdminid() {
        return adminid;
    }

    /**
     * Set the administrator ID.
     * 
     * @param adminid The administrator ID to set.
     */
    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    /**
     * Get the first name of the administrator.
     * 
     * @return The first name.
     */
    public String getfName() {
        return fName;
    }

    /**
     * Set the first name of the administrator.
     * 
     * @param fName The first name to set.
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * Get the last name of the administrator.
     * 
     * @return The last name.
     */
    public String getlName() {
        return lName;
    }

    /**
     * Set the last name of the administrator.
     * 
     * @param lName The last name to set.
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * Get the email address of the administrator.
     * 
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address of the administrator.
     * 
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the phone number of the administrator.
     * 
     * @return The phone number.
     */
    public String getPhonenum() {
        return phonenum;
    }

    /**
     * Set the phone number of the administrator.
     * 
     * @param phonenum The phone number to set.
     */
    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    /**
     * Get the username of the administrator.
     * 
     * @return The username.
     */
    public String getUsername1() {
        return username1;
    }

    /**
     * Set the username of the administrator.
     * 
     * @param username1 The username to set.
     */
    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    /**
     * Get the password of the administrator.
     * 
     * @return The password.
     */
    public String getPassword1() {
        return password1;
    }

    /**
     * Set the password of the administrator.
     * 
     * @param password1 The password to set.
     */
    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    /**
     * Get the roles assigned to the administrator.
     * 
     * @return The roles.
     */
    public String getRoles() {
        return roles;
    }

    /**
     * Set the roles assigned to the administrator.
     * 
     * @param roles The roles to set.
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }

    /**
     * Get the join date of the administrator.
     * 
     * @return The join date.
     */
    public Date getJoindate() {
        return joindate;
    }

    /**
     * Set the join date of the administrator.
     * 
     * @param joindate The join date to set.
     */
    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    /**
     * Returns a string representation of the Admint object.
     * 
     * @return A string representation of the Admint.
     */
    @Override
    public String toString() {
        return "Admint [adminid=" + adminid + ", fName=" + fName + ", lName=" + lName + ", email=" + email
                + ", phonenum=" + phonenum + ", username1=" + username1 + ", password1=" + password1 + ", roles="
                + roles + ", joindate=" + joindate + "]";
    }
}
