package com.lsmp.mp.customer.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.mp.customer.CustomerManager;
import com.lsmp.mp.customer.Phone;
import com.lsmp.mp.customer.service.representation.ShopperPhoneRepresentation;

public class ShopperPhoneActivity {

	private static CustomerManager customerManager = new CustomerManager();
	
	public ShopperPhoneRepresentation getShopperPhone(String id) {
		
		Phone phone = customerManager.getShopperPhone(id);
		
		ShopperPhoneRepresentation shopperPhoneRepresentation = new ShopperPhoneRepresentation();
		shopperPhoneRepresentation.setPhoneID(phone.getPhoneID());
		shopperPhoneRepresentation.setPhoneNumber(phone.getPhoneNumber());
		shopperPhoneRepresentation.setShopperProfileID(phone.getShopperProfileID());
		shopperPhoneRepresentation.setType(phone.getType());
		
		return shopperPhoneRepresentation;
	}

	public ShopperPhoneRepresentation insertShopperPhone(String pid, String id, String type, String phoneNumber) {
		
		Phone phone = customerManager.insertShopperPhone(pid, id, type, phoneNumber);
		
		ShopperPhoneRepresentation shopperPhoneRepresentation = new ShopperPhoneRepresentation();
		shopperPhoneRepresentation.setPhoneID(phone.getPhoneID());
		shopperPhoneRepresentation.setPhoneNumber(phone.getPhoneNumber());
		shopperPhoneRepresentation.setShopperProfileID(phone.getShopperProfileID());
		shopperPhoneRepresentation.setType(phone.getType());
		
		return shopperPhoneRepresentation;
	}

	public String updateShopperPhone(String pid, String id, String type, String phoneNumber) {
		customerManager.updateShopperPhone(pid, id, type, phoneNumber);
		return "OK";
	}

	public String deleteShopperPhone(String id) {
		customerManager.deleteShopperPhone(id);
		return "OK";
	}
	
	public Set<ShopperPhoneRepresentation> getShopperPhones(String id) {
		Set<Phone> phones = new HashSet<Phone>();
		Set<ShopperPhoneRepresentation> shopperPhoneRepresentations = new HashSet<ShopperPhoneRepresentation>();
		//employees = dao.getAllEmployees();
		phones = customerManager.getShopperPhones(id);
		
		Iterator<Phone> it = phones.iterator();
		while(it.hasNext()) {
          Phone phone = (Phone)it.next();
          ShopperPhoneRepresentation shopperPhoneRepresentation = new ShopperPhoneRepresentation();
          shopperPhoneRepresentation.setPhoneID(phone.getPhoneID());
  		  shopperPhoneRepresentation.setPhoneNumber(phone.getPhoneNumber());
  		  shopperPhoneRepresentation.setShopperProfileID(phone.getShopperProfileID());
  		  shopperPhoneRepresentation.setType(phone.getType());
          
          //now add this representation in the list
  		shopperPhoneRepresentations.add(shopperPhoneRepresentation);
        }
		return shopperPhoneRepresentations;
	}

}
