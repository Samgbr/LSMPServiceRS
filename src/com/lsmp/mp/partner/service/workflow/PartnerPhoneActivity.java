package com.lsmp.mp.partner.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.mp.customer.CustomerManager;
import com.lsmp.mp.customer.Phone;
import com.lsmp.mp.partner.service.representation.PartnerPhoneRepresentation;

public class PartnerPhoneActivity {

private static CustomerManager customerManager = new CustomerManager();
	
	public PartnerPhoneRepresentation getPartnerPhone(String id) {
		
		Phone phone = customerManager.getPartnerPhone(id);
		
		PartnerPhoneRepresentation partnerPhoneRepresentation = new PartnerPhoneRepresentation();
		partnerPhoneRepresentation.setPhoneID(phone.getPhoneID());
		partnerPhoneRepresentation.setPhoneNumber(phone.getPhoneNumber());
		partnerPhoneRepresentation.setPartnerProfileID(phone.getPartnerProfileID());
		partnerPhoneRepresentation.setType(phone.getType());
		
		return partnerPhoneRepresentation;
	}

	public PartnerPhoneRepresentation insertPartnerPhone(String pid, String id, String type, String phoneNumber) {
		
		Phone phone = customerManager.insertPartnerPhone(pid, id, type, phoneNumber);
		
		PartnerPhoneRepresentation partnerPhoneRepresentation = new PartnerPhoneRepresentation();
		partnerPhoneRepresentation.setPhoneID(phone.getPhoneID());
		partnerPhoneRepresentation.setPhoneNumber(phone.getPhoneNumber());
		partnerPhoneRepresentation.setPartnerProfileID(phone.getPartnerProfileID());
		partnerPhoneRepresentation.setType(phone.getType());
		
		return partnerPhoneRepresentation;
	}

	public String updatePartnerPhone(String pid, String id, String type, String phoneNumber) {
		customerManager.updatePartnerPhone(pid, id, type, phoneNumber);
		return "OK";
	}

	public String deletePartnerPhone(String id) {
		customerManager.deletePartnerPhone(id);
		return "OK";
	}
	
	public Set<PartnerPhoneRepresentation> getShopperPhones(String id) {
		Set<Phone> phones = new HashSet<Phone>();
		Set<PartnerPhoneRepresentation> partnerPhoneRepresentations = new HashSet<PartnerPhoneRepresentation>();
		
		phones = customerManager.getPartnerPhones(id);
		
		Iterator<Phone> it = phones.iterator();
		while(it.hasNext()) {
          Phone phone = (Phone)it.next();
          PartnerPhoneRepresentation partnerPhoneRepresentation = new PartnerPhoneRepresentation();
          partnerPhoneRepresentation.setPhoneID(phone.getPhoneID());
          partnerPhoneRepresentation.setPhoneNumber(phone.getPhoneNumber());
          partnerPhoneRepresentation.setPartnerProfileID(phone.getPartnerProfileID());
          partnerPhoneRepresentation.setType(phone.getType());
          
          //now add this representation in the list
          partnerPhoneRepresentations.add(partnerPhoneRepresentation);
        }
		return partnerPhoneRepresentations;
	}

}
