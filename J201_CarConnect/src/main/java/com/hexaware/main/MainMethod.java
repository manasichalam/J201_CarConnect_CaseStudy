package com.hexaware.main;

import java.sql.Date;



import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.hexaware.Controller.AdminService;
import com.hexaware.Controller.CustomerService;
import com.hexaware.Controller.ReservationService;
import com.hexaware.Controller.VechileService;
import com.hexaware.dao.CarConnectDao;
import com.hexaware.exception.AdminNotFoundException;
import com.hexaware.exception.AuthenticationException;
import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.ReservationException;
import com.hexaware.exception.VehicleNotFoundException;
import com.hexaware.model.Admint;
import com.hexaware.model.Customer;
import com.hexaware.model.Reservation;
import com.hexaware.model.Vechile;

/**
 * The MainMethod class represents the entry point of the application.
 */

public class MainMethod {
	private static CarConnectDao dao = new CarConnectDao();
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "password";
	
	
	/**
     * The main method serves as the entry point of the application.
     *
     * @param args Command-line arguments.
     * @throws SQLException                 If a database access error occurs.
     * @throws DatabaseConnectionException  If a database connection error occurs.
     * @throws VehicleNotFoundException     If a vehicle is not found.
     * @throws AdminNotFoundException       If an admin is not found.
     * @throws ReservationException         If an error occurs during reservation handling.
     * @throws AuthenticationException      If an authentication error occurs.
     * @throws CustomerNotFoundException    If a customer is not found.
     */
	
    public static void main(String[] args) throws SQLException, DatabaseConnectionException, VehicleNotFoundException, AdminNotFoundException, ReservationException, AuthenticationException, CustomerNotFoundException {
    	
    	CustomerService customerService = new CustomerService();
        VechileService vehicleService = new VechileService();
        ReservationService reservationService = new ReservationService(dao);
        AdminService adminService = new AdminService(dao);
    	Customer customer=new Customer();
    	Scanner sc = new Scanner(System.in);
    	String ch = "";
    	int choice;

        do {
            System.out.println("***************Menu**************");
            System.out.println("1. Customer");
            System.out.println("2. Vechile");
            System.out.println("3. Reservation");
            System.out.println("4.Admint");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                	do {
                		
                        System.out.println("***************CUSTOMER MENU***********************");
                        System.out.println("1. customerdetails through username");
                        System.out.println("2.register customer ");
                        System.out.println("3.update customerd ");
                        System.out.println("4.delete customer");
                        System.out.println("5.customerdetails through id");
                        System.out.println("6. Exit");
                        System.out.print("Enter your choice: ");
                        int  choice1 =sc.nextInt();
                        switch(choice1) {
                        case 1:
                        	String username = getCustomerusernameFromUserInput();
                            Customer user = dao.getCustomerByUsername(username);
                            System.out.println("Customer Information by username is :");
                            System.out.println(user);
                            break;
                        case 2:
                            Scanner scanner = new Scanner(System.in);
                        	
                        	
                        	System.out.print("Enter Cid: ");
                            int cid = scanner.nextInt();
                            customer.setCid(cid);
                        	
                            
                            System.out.print("Enter First Name: ");
                            String fName = scanner.nextLine();
                            customer.setFName(scanner.next());
                            
                            
                            
                            System.out.print("Enter Last Name: ");
                            String lName = scanner.nextLine();
                            customer.setLName(sc.next());
                            
                            System.out.print("Enter Email: ");
                           String email = scanner.nextLine();
                            customer.setEmail(sc.next());
                            
                            System.out.print("Enter Phone Number: ");
                            String phoneNumber = scanner.nextLine();
                            customer.setPhoneNumber(sc.next());
                            System.out.print("Enter Address: ");
                            String address = scanner.nextLine();
                            customer.setAddress(sc.next());
                            
                            System.out.print("Enter Username: ");
                            String username1 = scanner.nextLine();
                            customer.setUsername(sc.next());
                            
                            System.out.print("Enter Password: ");
                            String password = scanner.nextLine();
                            customer.setPassword(sc.next());
                            
                            dao.registerCustomer(customer);
                            System.out.println("Customer registered successfully.");
                            break;
                        	
                        case 3:
                        	
                        	Scanner scanner1 = new Scanner(System.in);
                        	System.out.print("Enter First Name: ");
                            String fName1 = scanner1.nextLine();
                            
                            System.out.print("Enter Last Name: ");
                            String lName1 = scanner1.nextLine();
                            
                            System.out.print("Enter Email: ");
                            String email1 = scanner1.nextLine();
                            
                            System.out.print("Enter Phone Number: ");
                            String phoneNumber1 = scanner1.nextLine();
                            
                            System.out.print("Enter Address: ");
                            String address1 = scanner1.nextLine();
                            
                            System.out.print("Enter Username: ");
                            String username11 = scanner1.nextLine();
                            
                            System.out.print("Enter Password: ");
                            String password1 = scanner1.nextLine();
                            
                            System.out.print("Enter Date ");
                            String registrationdate = scanner1.nextLine();
                            System.out.print("Enter cid: ");
                            int cid1 = scanner1.nextInt();
                            Customer customer1=new Customer(cid1,fName1,lName1,email1, phoneNumber1, address1,username11,password1,registrationdate);
                            dao.updateCustomer(customer1);
                            System.out.println("Customer updated successfully.");
                            break;
                        case 4:
                        	Scanner scanner2 = new Scanner(System.in);
                        	System.out.print("Enter cid: ");
                            int cid2 = scanner2.nextInt();
                            
                            dao.deleteCustomer(cid2);
                            System.out.println("deleted successfully)");
                            break;
               	
                        case 5:
                        	Scanner scanner11 = new Scanner(System.in);
                            System.out.print("Enter Customer ID: ");
                            int customerId=scanner11.nextInt();
                            Customer customerById = dao.getCustomerById(customerId);
                            System.out.println("Customer Information by ID:");
                            System.out.println(customerById);
                        default:
                            System.out.println("Invalid choice. Please try again.");
                        }System.out.println("Do you want to continue? (Y/N)");
                        ch = sc.next();
                        } while (ch.equalsIgnoreCase("Y"));
                        System.out.println("Thank you. Visit Again!");
              
                
                case 2:
                    do {
                        System.out.println("******************* VECHILE MENU******************");
                        System.out.println("1. Register Vehicle");
                        System.out.println("2. Update Vehicle");
                        System.out.println("3. Delete Vehicle");
                        System.out.println("4. View Vehicle Details");
                        System.out.println("5. Exit");
                        System.out.print("Enter your choice: ");
                        int choice2 = sc.nextInt();
                        
                        switch (choice2) {
                            case 1:
                            	System.out.print("Enter Vehicle ID : ");
                                int vid = sc.nextInt();
                                System.out.print("Enter Vehicle Model: ");
                                String model = sc.next();
                                
                                System.out.print("Enter Vehicle manuyeaer: ");
                                int type = sc.nextInt();
                                
                                System.out.print("Enter Vehicle Color: ");
                                String color = sc.next();
                                
                                System.out.print("Enter Vehicle regno: ");
                                String regno = sc.nextLine();
                                sc.nextLine();
                                
                                
                                System.out.print("Enter Vehicle avail: ");
                                boolean avaliability= Boolean.parseBoolean(sc.nextLine());
                                
                                System.out.print("Enter Vehicle Price: ");
                                double price = sc.nextDouble();
                                
                                Vechile newVehicle1 = new Vechile(vid, model, type, color,regno,avaliability, price);
                                dao.addVehicle(newVehicle1);
                                System.out.println("Vechile added successfully.");
                                break;
                            	
                            case 2:
                             
                                System.out.print("Enter Vehicle ID to update: ");
                                int updateVehicleId = sc.nextInt();
                                System.out.print("Enter Vehicle Model: ");
                                String model1 = sc.next();
                                
                                System.out.print("Enter Vehicle manuyeaer: ");
                                int manuyear = sc.nextInt();
                                
                                System.out.print("Enter Vehicle Color: ");
                                String color1 = sc.next();
                                
                                System.out.print("Enter Vehicle regno: ");
                                String regno1 = sc.nextLine();
                                sc.nextLine();
                                
                                System.out.print("Enter Vehicle avail: ");
                                boolean avaliability1= sc.nextLine() != null;
                                
                                System.out.print("Enter Vehicle Price: ");
                                double price1 = sc.nextDouble();
                                
                                Vechile newVehicle = new Vechile(updateVehicleId, model1, manuyear, color1,regno1,avaliability1, price1);
                                dao.updateVehicle(newVehicle);
                                System.out.println("vechile updated successfully.");
                                
                                
                                
                                break;
                                
                            case 3:
                            	Scanner scanner2 = new Scanner(System.in);
                            	System.out.print("Enter vid: ");
                                int vid2 = scanner2.nextInt();
                                
                                dao.removeVehicle(vid2);
                                System.out.println("deleted successfully)");
                                
                                break;
                                
                            case 4:
                            	System.out.print("Enter the Vehicle ID to view details: ");
                            	Scanner scanner=new Scanner(System.in);
                                int vehicleId = scanner.nextInt();
                                
                                try {
                                    Vechile vehicle = dao.getVehicleById(vehicleId);
                                    
                                    if (vehicle != null) {
                                        System.out.println("Vehicle Details:");
                                        System.out.println("ID: " + vehicle.getVid());
                                        System.out.println("Model: " + vehicle.getModel());
                                        System.out.println("Manufacture Year: " + vehicle.getManuyear());
                                        System.out.println("Color: " + vehicle.getColor());
                                        System.out.println("Registration Number: " + vehicle.getRegno());
                                        System.out.println("Availability: " + vehicle.isAvailability());
                                        System.out.println("Daily Rate: " + vehicle.getDailyRate());
                                    } else {
                                        System.out.println("Vehicle with ID " + vehicleId + " not found.");
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                break;
                                
                            case 5:
                                System.out.println("Exiting Vehicle Menu.");
                                break;
                                
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                        
                        System.out.println("Do you want to continue in Vehicle Menu? (Y/N)");
                        ch = sc.next();
                    } while (ch.equalsIgnoreCase("Y"));
                    break;
                	
                	
                
                case 3:
                    
                
                    do {
                        System.out.println("**************** RESERVATION MENU*************************");
                        System.out.println("1. Make a reservation");
                        System.out.println("2. View reservations by customer ID");
                        System.out.println("3. Cancel a reservation");
                        System.out.println("4. Exit");
                        System.out.print("Enter your choice: ");
                        int choice3 = sc.nextInt();
                        
                        switch (choice3) {
                            case 1:
                               
                                Reservation reservation = new Reservation();
                                Scanner scanner = new Scanner(System.in);
                                
                                
                                System.out.print("Enter Reservation ID: ");
                                int reservationid = scanner.nextInt();
                                reservation.setReservationID(reservationid);
                                
                                System.out.print("Enter Customer ID: ");
                                int cid = scanner.nextInt();
                                reservation.setCid(cid);
                                
                                System.out.print("Enter Vehicle ID: ");
                                int vid = scanner.nextInt();
                                reservation.setVid(vid);
                                LocalDate defaultStartDate = LocalDate.now(); 
                                LocalDate defaultEndDate = LocalDate.now().plusDays(1); 
                                
                                reservation.setStartdate(defaultStartDate.toString());
                                reservation.setEnddate(defaultEndDate.toString());
                                
                                System.out.println("Default Start Date: " + defaultStartDate);
                                System.out.println("Default End Date: " + defaultEndDate);
                                
                                
                                
                                System.out.print("Enter totalcost: ");
                                double totalcost = scanner.nextInt();
                                reservation.setTotalCost(totalcost);
                                
                                System.out.print("Enter statusof: ");
                                String statusof = scanner.nextLine();
                                reservation.setStatusof(statusof);
                         
                                dao.createReservation(reservation);
                                System.out.println("Reservation created successfully.");
                                break;
                            case 2:
                                
                                System.out.print("Enter reservation ID: ");
                                int customerId = sc.nextInt();
                                List<Reservation> reservations =dao.getReservationsByCustomerId(customerId);
                                System.out.println("Reservations for Customer ID " + customerId + ":");
                                for (Reservation res : reservations) {
                                    System.out.println(res);
                                }
                                break;
                            case 3:
                                
                                System.out.print("Enter Reservation ID to cancel: ");
                                int reservationId = sc.nextInt();
                                dao.cancelReservation(reservationId);
                                System.out.println("Reservation with ID " + reservationId + " canceled successfully.");
                                break;
                            case 4:
                                System.out.println("Exiting the reservation menu.");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                        System.out.println("Do you want to continue with reservations? (Y/N)");
                        ch = sc.next();
                    } while (ch.equalsIgnoreCase("Y"));
                    break;
                   
                case 4:
                	Scanner scanner = new Scanner(System.in);
                    
                    System.out.println("*************** ADMIN MENU****************");
                    System.out.println("1. Get Admin by ID");
                    System.out.println("2. Get Admin by Username");
                    System.out.println("3. Register Admin");
                    System.out.println("4. Update Admin");
                    System.out.println("5. Delete Admin");
                    System.out.println("6. do customer ops");
                    System.out.print("Enter your choice: ");
                    
                    int choice1 = scanner.nextInt();
                    
                    switch (choice1) {
                        case 1:
                            System.out.print("Enter Admin ID: ");
                            int adminId = scanner.nextInt();
                            try {
                                Admint adminById = dao.getAdminById(adminId);
                                System.out.println(adminById);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 2:
                            System.out.print("Enter Admin Username: ");
                            String username = scanner.next();
                            try {
                                Admint adminByUsername = dao.getAdminByUsername(username);
                                System.out.println(adminByUsername);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 3:
                        	Admint admin = new Admint();
                        	Scanner scanner1 = new Scanner(System.in);
                        	
                        	
                            
                            
                            System.out.print("Enter First Name: ");
                            String fName = scanner1.nextLine();
                            admin.setfName(fName);
                            
                            
                            System.out.print("Enter Last Name: ");
                            String lName = scanner1.nextLine();
                            admin.setlName(lName);
                            
                            System.out.print("Enter Email: ");
                            String email = scanner1.nextLine();
                            admin.setEmail(email);
                            
                            System.out.print("Enter Phone Number: ");
                            String phonenum = scanner1.nextLine();
                            admin.setPhonenum(phonenum);
                            
                            System.out.print("Enter Username: ");
                            String username1 = scanner1.nextLine();
                            admin.setUsername1(username1);
                            
                            System.out.print("Enter Password: ");
                            String password = scanner1.nextLine();
                            admin.setPassword1(password);
                            
                            System.out.print("Enter Roles: ");
                            String roles = scanner1.nextLine();
                            admin.setRoles(roles);
                            
                           
                            dao.registerAdmin(admin);
                            System.out.println("successfully registered");
                            break;
                        case 4:
                            Admint admin1=new Admint();
                        	Scanner scanner11 = new Scanner(System.in);
                            
                            
                            System.out.print("Enter Admin ID to update: ");
                            int adminid = scanner11.nextInt();
                            scanner11.nextLine(); 
                            System.out.print("Enter First Name: ");
                            String fName1 = scanner11.nextLine();
                            admin1.setfName(fName1);
                            
                            
                            System.out.print("Enter Last Name: ");
                            String lName1 = scanner11.nextLine();
                            admin1.setlName(lName1);
                            
                            System.out.print("Enter Email: ");
                            String email1 = scanner11.nextLine();
                            admin1.setEmail(email1);
                            
                            System.out.print("Enter Phone Number: ");
                            String phonenum1 = scanner11.nextLine();
                            admin1.setPhonenum(phonenum1);
                            
                            System.out.print("Enter Username: ");
                            String username11 = scanner11.nextLine();
                            admin1.setUsername1(username11);
                            
                            System.out.print("Enter Password: ");
                            String password1 = scanner11.nextLine();
                            admin1.setPassword1(password1);
                            
                            System.out.print("Enter Roles: ");
                            String roles1 = scanner11.nextLine();
                            admin1.setRoles(roles1);
                            dao.updateAdmin(admin1);
                            
                            
                                    
                                    
                            break;
                        case 5:
                        	Scanner sc1=new Scanner(System.in);
                            System.out.print("Enter Admin ID to delete: ");
                            int adminIdToDelete = sc1.nextInt();
                            try {
                                dao.deleteAdmin(adminIdToDelete);
                                System.out.println("Admin with ID " + adminIdToDelete + " deleted successfully.");
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            
                            break;
                        case 6:
                        	System.out.println("***********ADMIN OPS**********");
                        	System.out.println("7.Customer operations");
                        	System.out.println("8.vechile operations");
                        	
                        	System.out.print("Enter your choice: ");
                            choice = sc.nextInt();

                            switch (choice) {
                                case 7:
                                	do {
                                		
                                        System.out.println("***************CUSTOMER MENU***********************");
                                        System.out.println("1. customerdetails through username");
                                        System.out.println("2.register customer ");
                                        System.out.println("3.update customerd ");
                                        System.out.println("4.delete customer");
                                        System.out.println("5.customerdetails through id");
                                        System.out.println("6. Exit");
                                        System.out.print("Enter your choice: ");
                                        int  choice11 =sc.nextInt();
                                        switch(choice11) {
                                        case 1:
                                        	String username111 = getCustomerusernameFromUserInput();
                                            Customer user = dao.getCustomerByUsername(username111);
                                            System.out.println("Customer Information by username is :");
                                            System.out.println(user);
                                            break;
                                        case 2:
                                            Scanner scanner111 = new Scanner(System.in);
                                        	
                                        	
                                        	System.out.print("Enter Cid: ");
                                            int cid = scanner111.nextInt();
                                            customer.setCid(cid);
                                        	
                                            
                                            System.out.print("Enter First Name: ");
                                            String fName11 = scanner111.nextLine();
                                            customer.setFName(scanner111.next());
                                            
                                            
                                            
                                            System.out.print("Enter Last Name: ");
                                            String lName11 = scanner111.nextLine();
                                            customer.setLName(sc.next());
                                            
                                            System.out.print("Enter Email: ");
                                           String email11 = scanner111.nextLine();
                                            customer.setEmail(sc.next());
                                            
                                            System.out.print("Enter Phone Number: ");
                                            String phoneNumber = scanner111.nextLine();
                                            customer.setPhoneNumber(sc.next());
                                            System.out.print("Enter Address: ");
                                            String address = scanner111.nextLine();
                                            customer.setAddress(sc.next());
                                            
                                            System.out.print("Enter Username: ");
                                            String username1111 = scanner111.nextLine();
                                            customer.setUsername(sc.next());
                                            
                                            System.out.print("Enter Password: ");
                                            String password11 = scanner111.nextLine();
                                            customer.setPassword(sc.next());
                                            
                                            dao.registerCustomer(customer);
                                            System.out.println("Customer registered successfully.");
                                            break;
                                        	
                                        case 3:
                                        	
                                        	Scanner scanner1111 = new Scanner(System.in);
                                        	System.out.print("Enter First Name: ");
                                            String fName111 = scanner1111.nextLine();
                                            
                                            System.out.print("Enter Last Name: ");
                                            String lName111 = scanner1111.nextLine();
                                            
                                            System.out.print("Enter Email: ");
                                            String email111 = scanner1111.nextLine();
                                            
                                            System.out.print("Enter Phone Number: ");
                                            String phoneNumber1 = scanner1111.nextLine();
                                            
                                            System.out.print("Enter Address: ");
                                            String address1 = scanner1111.nextLine();
                                            
                                            System.out.print("Enter Username: ");
                                            String username11111 = scanner1111.nextLine();
                                            
                                            System.out.print("Enter Password: ");
                                            String password111 = scanner1111.nextLine();
                                            
                                            System.out.print("Enter Date ");
                                            String registrationdate = scanner1111.nextLine();
                                            System.out.print("Enter cid: ");
                                            int cid1 = scanner1111.nextInt();
                                            Customer customer1=new Customer(cid1,fName111,lName111,email111, phoneNumber1, address1,username11111,password111,registrationdate);
                                            dao.updateCustomer(customer1);
                                            System.out.println("Customer updated successfully.");
                                            break;
                                        case 4:
                                        	Scanner scanner2 = new Scanner(System.in);
                                        	System.out.print("Enter cid: ");
                                            int cid2 = scanner2.nextInt();
                                            
                                            dao.deleteCustomer(cid2);
                                            System.out.println("deleted successfully)");
                                            break;
                               	
                                        case 5:
                                        	Scanner scanner11111 = new Scanner(System.in);
                                            System.out.print("Enter Customer ID: ");
                                            int customerId=scanner11111.nextInt();
                                            Customer customerById = dao.getCustomerById(customerId);
                                            System.out.println("Customer Information by ID:");
                                            System.out.println(customerById);
                                        default:
                                            System.out.println("Invalid choice. Please try again.");
                                        }System.out.println("Do you want to continue? (Y/N)");
                                        ch = sc.next();
                                        } while (ch.equalsIgnoreCase("Y"));
                                        System.out.println("Thank you. Visit Again!");
                                case 8:
                                    do {
                                        System.out.println("******************* VECHILE MENU******************");
                                        System.out.println("1. Register Vehicle");
                                        System.out.println("2. Update Vehicle");
                                        System.out.println("3. Delete Vehicle");
                                        System.out.println("4. View Vehicle Details");
                                        System.out.println("5. Exit");
                                        System.out.print("Enter your choice: ");
                                        int choice2 = sc.nextInt();
                                        
                                        switch (choice2) {
                                            case 1:
                                            	System.out.print("Enter Vehicle ID : ");
                                                int vid = sc.nextInt();
                                                System.out.print("Enter Vehicle Model: ");
                                                String model = sc.next();
                                                
                                                System.out.print("Enter Vehicle manuyeaer: ");
                                                int type = sc.nextInt();
                                                
                                                System.out.print("Enter Vehicle Color: ");
                                                String color = sc.next();
                                                
                                                System.out.print("Enter Vehicle regno: ");
                                                String regno = sc.nextLine();
                                                sc.nextLine();
                                                
                                                
                                                System.out.print("Enter Vehicle avail: ");
                                                boolean avaliability= Boolean.parseBoolean(sc.nextLine());
                                                
                                                System.out.print("Enter Vehicle Price: ");
                                                double price = sc.nextDouble();
                                                
                                                Vechile newVehicle1 = new Vechile(vid, model, type, color,regno,avaliability, price);
                                                dao.addVehicle(newVehicle1);
                                                System.out.println("Vechile added successfully.");
                                                break;
                                            	
                                            case 2:
                                             
                                                System.out.print("Enter Vehicle ID to update: ");
                                                int updateVehicleId = sc.nextInt();
                                                System.out.print("Enter Vehicle Model: ");
                                                String model1 = sc.next();
                                                
                                                System.out.print("Enter Vehicle manuyeaer: ");
                                                int manuyear = sc.nextInt();
                                                
                                                System.out.print("Enter Vehicle Color: ");
                                                String color1 = sc.next();
                                                
                                                System.out.print("Enter Vehicle regno: ");
                                                String regno1 = sc.nextLine();
                                                sc.nextLine();
                                                
                                                System.out.print("Enter Vehicle avail: ");
                                                boolean avaliability1= sc.nextLine() != null;
                                                
                                                System.out.print("Enter Vehicle Price: ");
                                                double price1 = sc.nextDouble();
                                                
                                                Vechile newVehicle = new Vechile(updateVehicleId, model1, manuyear, color1,regno1,avaliability1, price1);
                                                dao.updateVehicle(newVehicle);
                                                System.out.println("vechile updated successfully.");
                                                
                                                
                                                
                                                break;
                                                
                                            case 3:
                                            	Scanner scanner2 = new Scanner(System.in);
                                            	System.out.print("Enter vid: ");
                                                int vid2 = scanner2.nextInt();
                                                
                                                dao.removeVehicle(vid2);
                                                System.out.println("deleted successfully)");
                                                
                                                break;
                                                
                                            case 4:
                                            	System.out.print("Enter the Vehicle ID to view details: ");
                                            	Scanner scanner111=new Scanner(System.in);
                                                int vehicleId = scanner111.nextInt();
                                                
                                                try {
                                                    Vechile vehicle = dao.getVehicleById(vehicleId);
                                                    
                                                    if (vehicle != null) {
                                                        System.out.println("Vehicle Details:");
                                                        System.out.println("ID: " + vehicle.getVid());
                                                        System.out.println("Model: " + vehicle.getModel());
                                                        System.out.println("Manufacture Year: " + vehicle.getManuyear());
                                                        System.out.println("Color: " + vehicle.getColor());
                                                        System.out.println("Registration Number: " + vehicle.getRegno());
                                                        System.out.println("Availability: " + vehicle.isAvailability());
                                                        System.out.println("Daily Rate: " + vehicle.getDailyRate());
                                                    } else {
                                                        System.out.println("Vehicle with ID " + vehicleId + " not found.");
                                                    }
                                                } catch (SQLException e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                                
                                            case 5:
                                                System.out.println("Exiting Vehicle Menu.");
                                                break;
                                                default:
                                                	System.out.println("Invalid choice. Please try again.");
                                                	}
                                        System.out.println("Do you want to continue in Vehicle Menu? (Y/N)");
                                        ch = sc.next();
                                        } while (ch.equalsIgnoreCase("Y"));
                                    break;
                                    } while (ch.equalsIgnoreCase("Y"));
                                    break;
                    }
                    default:
                    System.out.println("Invalid choice. Please try again.");
            }
		System.out.println("Do you want to continue? (Y/N)");
        ch = sc.next();
    } while (ch.equalsIgnoreCase("Y"));
    System.out.println("***Thank you. Visit Again!****");
    }
    
    
    /**
     * Prompts the user to input a customer username.
     *
     * @return The customer username entered by the user.
     */
    
    private static String getCustomerusernameFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Customer username: ");
        return scanner.nextLine();
    }
    
}
			
		
