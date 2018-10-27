package com.lsmp.mp.customer.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.mp.customer.Address;
import com.lsmp.mp.customer.CustomerManager;
import com.lsmp.mp.customer.service.representation.ShopperAddressRepresentation;

public class ShopperAddressActivity {
	
	private static CustomerManager customerManager = new CustomerManager();

	public ShopperAddressRepresentation getShopperAddress(String id) {
		
		Address address = customerManager.getShopperAddress(id);
		
		ShopperAddressRepresentation shopperAddressRepresentation = new ShopperAddressRepresentation();
		shopperAddressRepresentation.setAddressID(address.getAddressID());
		shopperAddressRepresentation.setCity(address.getCity());
		shopperAddressRepresentation.setState(address.getState());
		shopperAddressRepresentation.setStreet(address.getStreet());
		shopperAddressRepresentation.setZipcode(address.getZipcode());
		shopperAddressRepresentation.setShopperProfileID(address.getShopperProfileID());
		
		return shopperAddressRepresentation;
	}

	public ShopperAddressRepresentation createShopperAddress(String aid, String pid, String street, String city, String state, String zipcode) {
		
		Address address = customerManager.insertShopperAddress(aid, pid, street, city, state, zipcode);
		ShopperAddressRepresentation shopperAddressRepresentation =new ShopperAddressRepresentation();
		shopperAddressRepresentation.setAddressID(address.getAddressID());
		shopperAddressRepresentation.setCity(address.getCity());
		shopperAddressRepresentation.setShopperProfileID(address.getShopperProfileID());
		shopperAddressRepresentation.setState(address.getState());
		shopperAddressRepresentation.setStreet(address.getStreet());
		shopperAddressRepresentation.setZipcode(address.getZipcode());
		return shopperAddressRepresentation;
	}

	public String updateShopperAddress(String aid, String pid, String street, String city, String state, String zipcode) {
		customerManager.updateShopperAddress(aid, pid, street, city, state, zipcode);
		return "OK";
	}

	public String deleteShopperAddress(String id) {
		customerManager.deleteShopperAddress(id);
		return "OK";
	}

	public Set<ShopperAddressRepresentation> getShopperAddresses(String id) {
		Set<Address> addresses = new HashSet<Address>();
		Set<ShopperAddressRepresentation> shopperAddressRepresentations = new HashSet<ShopperAddressRepresentation>();
		//employees = dao.getAllEmployees();
		addresses = customerManager.getShopperAddresses(id);
		
		Iterator<Address> it = addresses.iterator();
		while(it.hasNext()) {
          Address address = (Address)it.next();
          ShopperAddressRepresentation shopperAddressRepresentation = new ShopperAddressRepresentation();
          shopperAddressRepresentation.setAddressID(address.getAddressID());
  		  shopperAddressRepresentation.setCity(address.getCity());
  		  shopperAddressRepresentation.setState(address.getState());
  		  shopperAddressRepresentation.setStreet(address.getStreet());
  		  shopperAddressRepresentation.setZipcode(address.getZipcode());
  		  shopperAddressRepresentation.setShopperProfileID(address.getShopperProfileID());
          
          //now add this representation in the list
  		shopperAddressRepresentations.add(shopperAddressRepresentation);
        }
		return shopperAddressRepresentations;
	}

	
}
