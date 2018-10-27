package com.lsmp.mp.partner.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.mp.customer.Address;
import com.lsmp.mp.customer.CustomerManager;
import com.lsmp.mp.partner.service.representation.PartnerAddressRepresentation;

public class PartnerAddressActivity {

	private static CustomerManager customerManager = new CustomerManager();

	public PartnerAddressRepresentation getPartnerAddress(String id) {
		
		Address address = customerManager.getPartnerAddress(id);
		
		PartnerAddressRepresentation partnerAddressRepresentation = new PartnerAddressRepresentation();
		partnerAddressRepresentation.setAddressID(address.getAddressID());
		partnerAddressRepresentation.setCity(address.getCity());
		partnerAddressRepresentation.setState(address.getState());
		partnerAddressRepresentation.setStreet(address.getStreet());
		partnerAddressRepresentation.setZipcode(address.getZipcode());
		partnerAddressRepresentation.setPartnerProfileID(address.getPartnerProfileID());
		
		return partnerAddressRepresentation;
	}

	public PartnerAddressRepresentation createPartnerAddress(String aid, String pid, String street, String city, String state, String zipcode) {
		
		Address address = customerManager.insertPartnerAddress(aid, pid, street, city, state, zipcode);
		PartnerAddressRepresentation partnerAddressRepresentation = new PartnerAddressRepresentation();
		partnerAddressRepresentation.setAddressID(address.getAddressID());
		partnerAddressRepresentation.setCity(address.getCity());
		partnerAddressRepresentation.setState(address.getState());
		partnerAddressRepresentation.setStreet(address.getStreet());
		partnerAddressRepresentation.setZipcode(address.getZipcode());
		partnerAddressRepresentation.setPartnerProfileID(address.getPartnerProfileID());
		
		return partnerAddressRepresentation;
	}

	public String updatePartnerAddress(String aid, String pid, String street, String city, String state, String zipcode) {
		customerManager.updatePartnerAddress(aid, pid, street, city, state, zipcode);
		return "OK";
	}

	public String deletePartnerAddress(String id) {
		customerManager.deletePartnerAddress(id);
		return "OK";
	}

	public Set<PartnerAddressRepresentation> getPartnerAddresses(String id) {
		Set<Address> addresses = new HashSet<Address>();
		Set<PartnerAddressRepresentation> partnerAddressRepresentations = new HashSet<PartnerAddressRepresentation>();
		//employees = dao.getAllEmployees();
		addresses = customerManager.getPartnerAddresses(id);
		
		Iterator<Address> it = addresses.iterator();
		while(it.hasNext()) {
          Address address = (Address)it.next();
          PartnerAddressRepresentation partnerAddressRepresentation = new PartnerAddressRepresentation();
          partnerAddressRepresentation.setAddressID(address.getAddressID());
  		  partnerAddressRepresentation.setCity(address.getCity());
  		  partnerAddressRepresentation.setState(address.getState());
  		  partnerAddressRepresentation.setStreet(address.getStreet());
  		  partnerAddressRepresentation.setZipcode(address.getZipcode());
  		  partnerAddressRepresentation.setPartnerProfileID(address.getPartnerProfileID());
          
          //now add this representation in the list
  		partnerAddressRepresentations.add(partnerAddressRepresentation);
        }
		return partnerAddressRepresentations;
	}

	
}
