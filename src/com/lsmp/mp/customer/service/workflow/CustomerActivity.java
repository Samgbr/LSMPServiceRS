package com.lsmp.mp.customer.service.workflow;

import com.lsmp.mp.customer.CustomerManager;
import com.lsmp.mp.customer.Shopper;
import com.lsmp.mp.customer.service.representation.CustomerRepresentation;

/**
 * This class is responsible for accessing the work flow of ShopperDAO CRUD object
 * @author samzi
 *
 */

public class CustomerActivity {
	
	private static CustomerManager customerManager = new CustomerManager();
	
	public CustomerRepresentation getShopper(String id) {
		
		Shopper shopper = customerManager.getShopperProfile(id);
		
		CustomerRepresentation customerRepresentation = new CustomerRepresentation();
		customerRepresentation.setProfileID(shopper.getProfileID());
		customerRepresentation.setLoginID(shopper.getLoginID());
		customerRepresentation.setFirstName(shopper.getFirstName());
		customerRepresentation.setMiddleName(shopper.getMiddleName());
		customerRepresentation.setLastName(shopper.getLastName());
		customerRepresentation.setEmail(shopper.getEmail());
		
		return customerRepresentation;
	}
	
}
