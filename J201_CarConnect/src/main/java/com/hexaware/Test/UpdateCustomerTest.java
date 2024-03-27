package com.hexaware.Test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.Controller.CustomerService;
import com.hexaware.dao.CarConnectDao;
import com.hexaware.model.Customer;

public class UpdateCustomerTest{
	
	 CustomerService cust=new CustomerService();
	 Customer customer=new Customer(); 
	 CarConnectDao dao=new CarConnectDao();
	 @Before
	 public void setUp() {
		 
		 cust=new CustomerService();
	 }
		 
	 
	 @Test
	 public void testUpdateCustomer() {
		 customer.setCid(9);
		 customer.setFName("subahs");
		 customer.setLName("aarti");
		 customer.setEmail("subu@gmail.com");
		 assertTrue(dao.updateCustomer(customer));
		 
	 }
	 @After
	 public void tearDown() {
		
		 dao=null;
	 }
}
