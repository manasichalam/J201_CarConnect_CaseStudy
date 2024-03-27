package com.hexaware.dao;

import java.sql.Connection;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.exception.AdminNotFoundException;
import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.exception.ReservationException;
import com.hexaware.exception.VehicleNotFoundException;
import com.hexaware.model.Admint;
import com.hexaware.model.Customer;
import com.hexaware.model.Reservation;
import com.hexaware.model.Vechile;
import com.hexaware.util.DBUtil;


/**
 * This class provides methods to interact with the database for Car Rental operations.
 */

public class CarConnectDao  {
	
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	
	/**
     * Constructor to initialize database connection.
     */
	
	public CarConnectDao() {
        con = DBUtil.getDBConn();
    }
	
	/**
     * Retrieves a customer from the database based on their ID.
     * 
     * @param customerId The ID of the customer.
     * @return The Customer object.
     * @throws CustomerNotFoundException If the customer with the given ID is not found.
     */
	
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
        Customer customer = null;
        String query = "SELECT * FROM Customer WHERE cid = ?";
        
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, customerId);
            ResultSet rs = statement.executeQuery();
            
            if (rs != null &&rs.next()) {
                
                customer = new Customer(rs.getInt("cid"),
                                        rs.getString("FName"),
                                        rs.getString("LName"),
                                        rs.getString("Email"),
                                        rs.getString("PhoneNumber"),
                                        rs.getString("Address"),
                                        rs.getString("Username"),
                                        rs.getString("Password"),
                                        rs.getString("RegistrationDate"));
            }else {
                throw new CustomerNotFoundException("Customer ID: " + customerId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return customer;
    }
	
	
	/**
     * Retrieves a customer from the database based on their username.
     * 
     * @param username The username of the customer.
     * @return The Customer object.
     * @throws CustomerNotFoundException If the customer with the given username is not found.
     */
	
	public Customer getCustomerByUsername(String username) throws CustomerNotFoundException {
        Customer customer = null;
        String query = "SELECT * FROM Customer WHERE username = ?";
        
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            
            if (rs != null &&rs.next()) {
                
                customer = new Customer(rs.getInt("cid"),
                                        rs.getString("FName"),
                                        rs.getString("LName"),
                                        rs.getString("Email"),
                                        rs.getString("PhoneNumber"),
                                        rs.getString("Address"),
                                        rs.getString("Username"),
                                        rs.getString("Password"),
                                        rs.getString("RegistrationDate"));
            
            }else {
                throw new CustomerNotFoundException("username " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return customer;
    }
	
	/**
     * Registers a new customer in the database.
     * 
     * @param customer The Customer object to be registered.
     */
	
	public void registerCustomer(Customer customer) {
        String query = "INSERT INTO Customer (Cid,FName, LName, Email, PhoneNumber, Address, Username, Password, RegistrationDate) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement statement = con.prepareStatement(query)) {
        	statement.setInt(1, customer.getCid());
            statement.setString(2, customer.getFName());
            statement.setString(3, customer.getLName());
            statement.setString(4, customer.getEmail());
            statement.setString(5, customer.getPhoneNumber());
            statement.setString(6, customer.getAddress());
            statement.setString(7, customer.getUsername());
            statement.setString(8, customer.getPassword());
            statement.setString(9, customer.getRegistrationDate());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            if (e.getSQLState().equals("23000")) {
                System.out.println("Duplicate entry for customer ID. Please try again.");
            } else {
                e.printStackTrace();
            }
        }
    }
	
	/**
     * Updates an existing customer's information in the database.
     * 
     * @param customer The updated Customer object.
     */


	public boolean updateCustomer(Customer customer) {
		boolean res=true;
        String query = "UPDATE Customer SET FName = ?, LName = ?, email = ?, phonenumber = ?, address = ?, username = ?, password = ?,registrationdate=? WHERE cid = ?";
        
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, customer.getFName());
            statement.setString(2, customer.getLName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhoneNumber());
            statement.setString(5, customer.getAddress());
            statement.setString(6, customer.getUsername());
            statement.setString(7, customer.getPassword());
            statement.setString(8, customer.getRegistrationDate());
            statement.setInt(9, customer.getCid());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
	
	/**
     * Deletes a customer from the database based on their ID.
     * 
     * @param customerId The ID of the customer to be deleted.
     */
	public void deleteCustomer(int customerId) {
        String query = "DELETE FROM Customer WHERE cid = ?";
        
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, customerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	/**
     * Retrieves a vehicle from the database based on its ID.
     * 
     * @param vehicleId The ID of the vehicle.
     * @return The Vehicle object.
     * @throws VehicleNotFoundException If the vehicle with the given ID is not found.
     */

    public Vechile getVehicleById(int vehicleId) throws SQLException, VehicleNotFoundException {
    	Vechile vehicle = new Vechile(vehicleId);
        try {
            con = DBUtil.getDBConn();
            String query = "SELECT * FROM Vechile WHERE vid = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, vehicleId);
            rs = ps.executeQuery();
            if (rs.next()) {
                vehicle.setVid(rs.getInt("vid"));
                vehicle.setModel(rs.getString("model"));
                
                vehicle.setManuyear(rs.getInt("manuyear"));
                vehicle.setColor(rs.getString("color"));
                vehicle.setRegno(rs.getString("regno"));
                vehicle.setAvaliability(rs.getBoolean("avaliability"));
                vehicle.setDailyRate(rs.getDouble("dailyRate"));
            }else {
            	throw new VehicleNotFoundException("vechile with id "+vehicleId+"not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    public List<Vechile> getAvailableVehicles() throws SQLException {
    	
        List<Vechile> vehicles = new ArrayList<>();
        try {
            con = DBUtil.getDBConn();
            String query = "SELECT * FROM Vechile WHERE availability = ?";
            ps = con.prepareStatement(query);
           
            rs = ps.executeQuery();
            while (rs.next()) {
            	Vechile vehicle = new Vechile();
                
                vehicle.setVid(rs.getInt("VehicleId"));
                vehicle.setModel(rs.getString("model"));
                
                vehicle.setManuyear(rs.getInt("manuyear"));
                vehicle.setColor(rs.getString("color"));
                vehicle.setRegno(rs.getString("regno"));
                vehicle.setAvaliability(rs.getBoolean("avaliability"));
                vehicle.setDailyRate(rs.getDouble("dailyrate"));
                
                
                
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
    public boolean addVehicle(Vechile vehicle) throws SQLException {
    	boolean res=true;
        try {
            con = DBUtil.getDBConn();
            String query = "INSERT INTO Vechile (vid,model,  manuyear, color, regno, avaliability, dailyrate) VALUES (?,?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
           
            ps.setInt(1, vehicle.getVid());
            ps.setString(2, vehicle.getModel());
            ps.setInt(3, vehicle.getManuyear());
            ps.setString(4, vehicle.getColor());
            ps.setString(5, vehicle.getRegno());
            ps.setBoolean(6, vehicle.isAvailability());
            ps.setDouble(7, vehicle.getDailyRate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public boolean updateVehicle(Vechile vehicle) throws SQLException {
    	boolean res=true;
        try {
            con = DBUtil.getDBConn();
            String query = "UPDATE Vechile SET model = ?, manuyear = ?, color = ?, regno = ?, avaliability = ?, dailyRate = ? WHERE vid = ?";
            ps = con.prepareStatement(query);
            
            ps.setString(1, vehicle.getModel());
           
            ps.setInt(2, vehicle.getManuyear());
            ps.setString(3, vehicle.getColor());
            ps.setString(4, vehicle.getRegno());
            ps.setBoolean(5, vehicle.isAvailability());
            ps.setDouble(6, vehicle.getDailyRate());
            ps.setInt(7, vehicle.getVid());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public void removeVehicle(int vehicleId) throws SQLException {
        try {
            con = DBUtil.getDBConn();
            String query = "DELETE FROM Vechile WHERE vid = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, vehicleId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Reservation getReservationById(int reservationId) throws SQLException, ReservationException {
        Reservation reservation = new Reservation();
        try {
            con = DBUtil.getDBConn();
            String query = "SELECT * FROM reservation WHERE reservationid = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, reservationId);
            rs = ps.executeQuery();
            if (rs.next()) {
                reservation.setReservationID(rs.getInt("reservationid"));
                
            }else {
                throw new ReservationException("Reservation with ID " + reservationId + " not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return reservation;
    }
    public List<Reservation> getReservationsByCustomerId(int customerId) throws SQLException, ReservationException {
        List<Reservation> reservations = new ArrayList<>();
        try {
            con = DBUtil.getDBConn();
            String query = "SELECT * FROM reservation WHERE cid = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, customerId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationID(rs.getInt("reservationid"));
                
                
                reservations.add(reservation);
            }else {
                throw new ReservationException("Reservation with ID " + customerId + " not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return reservations;
    }
    public void createReservation(Reservation reservation) throws SQLException {
    	
        try {
            con = DBUtil.getDBConn();
            String query = "INSERT INTO reservation (cid, vid, startdate, enddate, totalCost, statusof) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            
            ps.setInt(1, reservation.getCid());
            ps.setInt(2, reservation.getVid());
            ps.setString(3, reservation.getStartdate());
            ps.setString(4, reservation.getEnddate());
            ps.setDouble(5, reservation.getTotalCost());
            ps.setString(6, reservation.getStatusof());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateReservation(Reservation reservation) throws SQLException {
        try {
            con = DBUtil.getDBConn();
            String query = "UPDATE reservation SET cid = ?, vid = ?, startdate = ?, enddate = ?, totalCost = ?, statusof = ? WHERE reservationId = ?";
            ps = con.prepareStatement(query);
           
            ps.setInt(1, reservation.getCid());
            ps.setInt(2, reservation.getVid());
            ps.setString(3, reservation.getStartdate());
            ps.setString(4, reservation.getEnddate());
            ps.setDouble(5, reservation.getTotalCost());
            ps.setString(6, reservation.getStatusof());
            ps.setInt(7, reservation.getReservationID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void cancelReservation(int reservationId) throws SQLException {
        try {
            con = DBUtil.getDBConn();
            String query = "DELETE FROM reservation WHERE reservationid = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, reservationId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Admint getAdminById(int adminId) throws SQLException, AdminNotFoundException {
        Admint admin = new Admint();
        try {
            con = DBUtil.getDBConn();
            String query = "SELECT * FROM Admint WHERE adminid = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, adminId);
            
            
            rs = ps.executeQuery();
            if (rs.next()) {
                admin.setAdminid(rs.getInt("adminId"));
                admin.setfName(rs.getString("fname"));
                admin.setlName(rs.getString("lname"));
                admin.setEmail(rs.getString("email"));
                admin.setPhonenum(rs.getString("Phonenum"));
                admin.setUsername1(rs.getString("adminId"));
                admin.setPassword1(rs.getString("adminId"));
                admin.setRoles(rs.getString("adminId"));
                
               
            }else {
                throw new AdminNotFoundException("Admin with ID " + adminId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        return admin;
}
    
    public Admint getAdminByUsername(String username) throws SQLException, AdminNotFoundException {
        Admint admin = new Admint();
        try {
            con = DBUtil.getDBConn();
            String query = "SELECT * FROM Admint WHERE username1 = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                admin.setAdminid(rs.getInt("adminId"));
                admin.setfName(rs.getString("fname"));
                admin.setlName(rs.getString("lname"));
                admin.setEmail(rs.getString("email"));
                admin.setPhonenum(rs.getString("Phonenum"));
                admin.setUsername1(rs.getString("adminId"));
                admin.setPassword1(rs.getString("adminId"));
                admin.setRoles(rs.getString("adminId"));
            }
            else {
                throw new AdminNotFoundException("Admin with ID " + username + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return admin;
    }
    public void registerAdmin(Admint admin) throws SQLException {
        try {
            con = DBUtil.getDBConn();
            String query = "INSERT INTO Admint (fname, lname, email, phonenum, username1, password1,roles) VALUES (?, ?, ?, ?, ?, ?,?)";
            ps = con.prepareStatement(query);
            
            ps.setString(1, admin.getfName());
            ps.setString(2, admin.getlName());
            ps.setString(3, admin.getEmail());
            ps.setString(4, admin.getPhonenum());
            ps.setString(5, admin.getUsername1());
            ps.setString(6, admin.getPassword1());
            ps.setString(7, admin.getRoles());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateAdmin(Admint admin1) throws SQLException {
        try {
            con = DBUtil.getDBConn();
            String query = "UPDATE Admint SET fname = ?, lname = ?, email = ?, Phonenum = ?, password1 = ? WHERE adminid = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, admin1.getfName());
            ps.setString(2, admin1.getlName());
            ps.setString(3, admin1.getEmail());
            ps.setString(4, admin1.getPhonenum());
            ps.setString(5, admin1.getPassword1());
            ps.setInt(6, admin1.getAdminid());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAdmin(int adminId) throws SQLException {
        try {
            con = DBUtil.getDBConn();
            String query = "DELETE FROM Admint WHERE adminid = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, adminId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

   
 
    
    
            
		

	 
	       
