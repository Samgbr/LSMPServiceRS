package com.lsmp.mp.customer.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.mp.customer.Address;
import com.lsmp.mp.customer.Bill;
import com.lsmp.mp.customer.CustomerManager;
import com.lsmp.mp.customer.Phone;
import com.lsmp.mp.customer.Shopper;
import com.lsmp.mp.customer.service.representation.CustomerRepresentation;
import com.lsmp.mp.link.Link;

/**
 * This class is responsible for accessing the work flow of ShopperDAO CRUD object
 * @author samzi
 *
 */

public class CustomerActivity {
	
	private static CustomerManager customerManager = new CustomerManager();
	
	
	public Set<CustomerRepresentation> getShoppers() {
		
		Set<Shopper> shoppers = new HashSet<Shopper>();
		Set<CustomerRepresentation> shopperRepresentations = new HashSet<CustomerRepresentation>();
		//employees = dao.getAllEmployees();
		shoppers = customerManager.getAllShopperProfiles();
		
		Iterator<Shopper> it = shoppers.iterator();
		while(it.hasNext()) {
          Shopper shopper = (Shopper)it.next();
          CustomerRepresentation customerRepresentation = new CustomerRepresentation();
          customerRepresentation.setProfileID(shopper.getProfileID());
  		  customerRepresentation.setLoginID(shopper.getLoginID());
  		  customerRepresentation.setFirstName(shopper.getFirstName());
  		  customerRepresentation.setMiddleName(shopper.getMiddleName());
  		  customerRepresentation.setLastName(shopper.getLastName());
  		  customerRepresentation.setEmail(shopper.getEmail());
  		  customerRepresentation.setShopperType(shopper.getShopperType());
  		  customerRepresentation.setAddresses(shopper.getAddresses());
  		  customerRepresentation.setBills(shopper.getBillingsInfo());
  		  customerRepresentation.setPhones(shopper.getPhones());
          //now add this representation in the list
  		shopperRepresentations.add(customerRepresentation);
        }
		return shopperRepresentations;
	}
	
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
		customerRepresentation.setAddresses(shopper.getAddresses());
		customerRepresentation.setBills(shopper.getBillingsInfo());
		customerRepresentation.setPhones(shopper.getPhones());
		setLinks(customerRepresentation);
		return customerRepresentation;
	}
	
	public CustomerRepresentation getShopperByUsernameAndPassword(String id,String pwd) {
		
		Shopper shopper = customerManager.getShopperByUsernameAndPassword(id, pwd);
		
		CustomerRepresentation customerRepresentation = new CustomerRepresentation();
		customerRepresentation.setProfileID(shopper.getProfileID());
		customerRepresentation.setLoginID(shopper.getLoginID());
		customerRepresentation.setFirstName(shopper.getFirstName());
		customerRepresentation.setMiddleName(shopper.getMiddleName());
		customerRepresentation.setLastName(shopper.getLastName());
		customerRepresentation.setEmail(shopper.getEmail());
		customerRepresentation.setShopperType(shopper.getShopperType());
		customerRepresentation.setAddresses(shopper.getAddresses());
		customerRepresentation.setBills(shopper.getBillingsInfo());
		customerRepresentation.setPhones(shopper.getPhones());
		
		return customerRepresentation;
	}
	
	//new changes by Nasr
	public CustomerRepresentation createShopper(String loginID, String firstName, String middleName, String lastName, String email, String password, String shopperType,Set<Address> addresses, Set<Phone> phones, Set<Bill> bills) {
		
		Shopper shopper=customerManager.addShopperProfile(loginID, firstName, middleName, lastName, email, password, shopperType, addresses, phones, bills);
		

		CustomerRepresentation customerRepresentation = new CustomerRepresentation();
		customerRepresentation.setProfileID(shopper.getProfileID());
		customerRepresentation.setLoginID(shopper.getLoginID());
		customerRepresentation.setFirstName(shopper.getFirstName());
		customerRepresentation.setMiddleName(shopper.getMiddleName());
		customerRepresentation.setLastName(shopper.getLastName());
		customerRepresentation.setEmail(shopper.getEmail());
		customerRepresentation.setPassword(shopper.getPassword());
		customerRepresentation.setShopperType(shopper.getShopperType());
		customerRepresentation.setAddresses(shopper.getAddresses());
		customerRepresentation.setBills(shopper.getBillingsInfo());
		customerRepresentation.setPhones(shopper.getPhones());
		
		return customerRepresentation;
	}
	
	private void setLinks(CustomerRepresentation customerRepresentation) {
		Link updatecustomer = new Link("updatecustomer", 
				"http://localhost:8082/Customer/shopperservice/shopper" ,"application/xml");
		Link deletecustomer = new Link("deletecustomer", 
				"http://localhost:8082/Customer/shopperservice/shopper/"+ customerRepresentation.getProfileID() ,"application/xml");
		customerRepresentation.setLinks(updatecustomer,deletecustomer);
	}

	public String deleteShopper(String id) {
		
		customerManager.deleteShopperProfile(id);
		return "OK";
		
	}

	public String updateShopper(String id, String loginID, String firstName, String middleName,
			String lastName, String email, String password, String shopperType,Set<Address> addresses, Set<Phone> phones, Set<Bill> bills) {
		customerManager.updateShopperProfile(id, loginID, firstName, middleName, lastName, email, password, shopperType, addresses, phones, bills);
		return "OK";
	}

	


	
}
