package com.lsmp.mp.partner.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.mp.customer.Bill;
import com.lsmp.mp.customer.CustomerManager;
import com.lsmp.mp.partner.service.representation.PartnerBillingRepresentation;

public class PartnerBillingActivity {

private static CustomerManager customerManager = new CustomerManager();
	
	public PartnerBillingRepresentation getPartnerBillingInfo(String id) {
		
		Bill bill = customerManager.getPartnerBillingInfo(id);
		
		PartnerBillingRepresentation partnerBillingRepresentation = new PartnerBillingRepresentation();
		
		partnerBillingRepresentation.setBillID(bill.getBillID());
		partnerBillingRepresentation.setCreditCardNumber(bill.getCreditCardNumber());
		partnerBillingRepresentation.setCvv(bill.getCvv());
		partnerBillingRepresentation.setExpiryMonth(bill.getExpiryMonth());
		partnerBillingRepresentation.setExpiryYear(bill.getExpiryYear());
		partnerBillingRepresentation.setPartnerProfileID(bill.getPartnerProfileID());
		
		return partnerBillingRepresentation;
	}

	public PartnerBillingRepresentation insertPartnerBillingInfo(String bid, String id, String creditCardNumber, int cvv, int expiryMonth, int expiryYear) {
		
		Bill bill = customerManager.insertPartnerBillingInfo(bid, id, creditCardNumber, cvv, expiryMonth, expiryYear);
		
		PartnerBillingRepresentation partnerBillingRepresentation = new PartnerBillingRepresentation();
		
		partnerBillingRepresentation.setBillID(bill.getBillID());
		partnerBillingRepresentation.setCreditCardNumber(bill.getCreditCardNumber());
		partnerBillingRepresentation.setCvv(bill.getCvv());
		partnerBillingRepresentation.setExpiryMonth(bill.getExpiryMonth());
		partnerBillingRepresentation.setExpiryYear(bill.getExpiryYear());
		partnerBillingRepresentation.setPartnerProfileID(bill.getPartnerProfileID());
		
		return partnerBillingRepresentation;
	}

	public String updatePartnerBillingInfo(String bid, String id, String creditCardNumber, int cvv, int expiryMonth, int expiryYear) {
		customerManager.updatePartnerBillingInfo(bid, id, creditCardNumber, cvv, expiryMonth, expiryYear);
		return "OK";
	}

	public String deletePartnerBillingInfo(String id) {
		customerManager.deletePartnerBillingInfo(id);
		return "OK";
	}
	
	public Set<PartnerBillingRepresentation> getPartnerBillingInfos(String id) {
		
		Set<Bill> bills = new HashSet<Bill>();
		Set<PartnerBillingRepresentation> partnerBillingRepresentations = new HashSet<PartnerBillingRepresentation>();
		
		bills = customerManager.getPartnerBillingInfos(id);
		
		Iterator<Bill> it = bills.iterator();
		while(it.hasNext()) {
          Bill bill = (Bill)it.next();
          
          PartnerBillingRepresentation partnerBillingRepresentation = new PartnerBillingRepresentation();
  		
  		partnerBillingRepresentation.setBillID(bill.getBillID());
  		partnerBillingRepresentation.setCreditCardNumber(bill.getCreditCardNumber());
  		partnerBillingRepresentation.setCvv(bill.getCvv());
  		partnerBillingRepresentation.setExpiryMonth(bill.getExpiryMonth());
  		partnerBillingRepresentation.setExpiryYear(bill.getExpiryYear());
  		partnerBillingRepresentation.setPartnerProfileID(bill.getPartnerProfileID());
          
          //now add this representation in the list
  		partnerBillingRepresentations.add(partnerBillingRepresentation);
        }
		return partnerBillingRepresentations;
	}

}
