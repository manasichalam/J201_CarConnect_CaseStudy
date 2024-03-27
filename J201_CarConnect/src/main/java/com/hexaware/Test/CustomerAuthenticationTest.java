package com.hexaware.Test;

import org.junit.Test;

import com.hexaware.Controller.AuthenticationServiceCont;
import com.hexaware.dao.CarConnectDao;
import com.hexaware.exception.AuthenticationException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;

public class CustomerAuthenticationTest {
	AuthenticationServiceCont authser;
	CarConnectDao dao=new CarConnectDao();
	
	@Before
	
	public void setUp() {
		authser=new AuthenticationServiceCont();
		
	}
	
	@Test
	
	
	public void testCustomerAuthenticationWithValidCredentials() throws AuthenticationException {
	    
	    String username = "janesm";
	    String password = "password456";
	    
	   
	    boolean isAuthenticated = authser.authenticate(username, password);
	    
	    
	    assertTrue("Authentication failed for valid credentials. Username: " + username + ", Password: " + password, isAuthenticated);
	}


	
	 @After
	 public void tearDown() {
		 authser=null;
	 }
	 
}



    
        