package com.lsmp.mp.customer.service.workflow;

import javax.ws.rs.core.Response;

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
		customerRepresentation.setShopperType(shopper.getShopperType());
		
		return customerRepresentation;
	}
	
	//new changes by Nasr
	public CustomerRepresentation createShopper(String id, String loginID, String firstName, String middleName, String lastName, String email, String password, String shopperType) {
		
		Shopper shopper=customerManager.addShopper(id, loginID, firstName, middleName, lastName, email, password, shopperType);
		

		CustomerRepresentation customerRepresentation = new CustomerRepresentation();
		customerRepresentation.setProfileID(shopper.getProfileID());
		customerRepresentation.setLoginID(shopper.getLoginID());
		customerRepresentation.setFirstName(shopper.getFirstName());
		customerRepresentation.setMiddleName(shopper.getMiddleName());
		customerRepresentation.setLastName(shopper.getLastName());
		customerRepresentation.setEmail(shopper.getEmail());
		customerRepresentation.setPassword(shopper.getPassword());
		customerRepresentation.setShopperType(shopper.getShopperType());
		
		return customerRepresentation;
	}
	
	public String deleteShopper(String id) {
		
		customerManager.deleteShopper(id);
		return "OK";
		
	}

	public String updateShopper(String id, String loginID, String firstName, String middleName,
			String lastName, String email, String password, String shopperType) {
		customerManager.updateShopper(id, loginID, firstName, middleName, lastName, email, password, shopperType);
		return "OK";
	}

	


	
}
