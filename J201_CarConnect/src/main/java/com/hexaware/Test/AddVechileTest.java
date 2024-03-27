package com.hexaware.Test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.Controller.VechileService;
import com.hexaware.dao.CarConnectDao;
import com.hexaware.model.Vechile;

public class AddVechileTest {
	 VechileService vehicleService;
	 CarConnectDao dao=new CarConnectDao();
	 Vechile vechile=new Vechile();
	 

	    @Before
	    public void setUp() {
	        Vechile vechile=new Vechile();
	        CarConnectDao dao=new CarConnectDao();
	        vehicleService = new VechileService();
	    }

	    @Test
	    public void testAddVehicle() throws SQLException {
	    	
	    
	        vechile.setModel("Activa");
	        vechile.setManuyear(2024);
	        vechile.setColor("black");
	        
			assertTrue(dao.addVehicle(vechile));
	    }

	    
		@After
	    public void tearDown() {
	        
	        dao = null;
	    }
	

}
