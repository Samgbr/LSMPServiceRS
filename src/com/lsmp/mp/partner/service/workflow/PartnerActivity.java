package com.lsmp.mp.partner.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.mp.customer.Address;
import com.lsmp.mp.customer.Bill;
import com.lsmp.mp.customer.Phone;
import com.lsmp.mp.link.Link;
import com.lsmp.mp.partner.Partner;
import com.lsmp.mp.partner.PartnerManager;
import com.lsmp.mp.partner.service.representation.PartnerRepresentation;

public class PartnerActivity {

	private static PartnerManager partnerManager = new PartnerManager();
	
	public PartnerRepresentation getPartner(String id) {
		
		Partner partner = partnerManager.getPartnerProfile(id);
		
		PartnerRepresentation partnerRepresentation = new PartnerRepresentation();
		partnerRepresentation.setProfileID(partner.getProfileID());
		partnerRepresentation.setLoginID(partner.getLoginID());
		partnerRepresentation.setFirstName(partner.getFirstName());
		partnerRepresentation.setMiddleName(partner.getMiddleName());
		partnerRepresentation.setLastName(partner.getLastName());
		partnerRepresentation.setEmail(partner.getEmail());
		partnerRepresentation.setSellerLevel(partner.getSellerLevel());
		partnerRepresentation.setSellerName(partner.getSellerName());
		partnerRepresentation.setAddresses(partner.getAddresses());
		partnerRepresentation.setBillingsInfo(partner.getBillingsInfo());
		partnerRepresentation.setPhones(partner.getPhones());
		
		return partnerRepresentation;
	}

	public Set<PartnerRepresentation> getPartners() {
		
		Set<Partner> partners = new HashSet<Partner>();
		Set<PartnerRepresentation> partnerRepresentations = new HashSet<PartnerRepresentation>();
		
		partners = partnerManager.getAllPartnerProfiles();
		
		Iterator<Partner> it = partners.iterator();
		while(it.hasNext()) {
          Partner partner = (Partner)it.next();
          PartnerRepresentation partnerRepresentation = new PartnerRepresentation();
          partnerRepresentation.setProfileID(partner.getProfileID());
          partnerRepresentation.setLoginID(partner.getLoginID());
          partnerRepresentation.setFirstName(partner.getFirstName());
          partnerRepresentation.setMiddleName(partner.getMiddleName());
          partnerRepresentation.setLastName(partner.getLastName());
          partnerRepresentation.setEmail(partner.getEmail());
          partnerRepresentation.setSellerLevel(partner.getSellerLevel());
          partnerRepresentation.setSellerName(partner.getSellerName());
          partnerRepresentation.setAddresses(partner.getAddresses());
  		  partnerRepresentation.setBillingsInfo(partner.getBillingsInfo());
  		  partnerRepresentation.setPhones(partner.getPhones());
          
          //now add this representation in the list
          partnerRepresentations.add(partnerRepresentation);
        }
		return partnerRepresentations;
	}

	public PartnerRepresentation createPartner(String loginID, String firstName, String middleName,
			String lastName, String email, String password, String sellerLevel, String sellerName, Set<Address> addresses, Set<Phone> phones, Set<Bill> bills) {
		
		Partner partner = partnerManager.addPartnerProfile(loginID, firstName, middleName, lastName, email, password, sellerLevel, sellerName, addresses, phones, bills);
		
		PartnerRepresentation partnerRepresentation = new PartnerRepresentation();
        partnerRepresentation.setProfileID(partner.getProfileID());
        partnerRepresentation.setLoginID(partner.getLoginID());
        partnerRepresentation.setFirstName(partner.getFirstName());
        partnerRepresentation.setMiddleName(partner.getMiddleName());
        partnerRepresentation.setLastName(partner.getLastName());
        partnerRepresentation.setEmail(partner.getEmail());
        partnerRepresentation.setSellerLevel(partner.getSellerLevel());
        partnerRepresentation.setSellerName(partner.getSellerName());
        partnerRepresentation.setAddresses(partner.getAddresses());
		partnerRepresentation.setBillingsInfo(partner.getBillingsInfo());
		partnerRepresentation.setPhones(partner.getPhones());
        
		setLinks(partnerRepresentation);
		
		return partnerRepresentation;
	}

	private void setLinks(PartnerRepresentation partnerRepresentation) {
		Link updatepartner = new Link("updatepartner", 
				"http://localhost:8082/Partner/partnerservice/partner" ,"application/xml");
		Link deletepartner = new Link("deletepartner", 
				" http://localhost:8082/Partner/partnerservice/partner/"+ partnerRepresentation.getProfileID() ,"application/xml");
		Link addproduct = new Link("addproduct", 
				" http://localhost:8082/BookProduct/bookservice/book" ,"application/xml");
		partnerRepresentation.setLinks(updatepartner,deletepartner,addproduct);
	}

	public String updatePartner(String id, String loginID, String firstName, String middleName, String lastName,
			String email, String password, String sellerLevel, String sellerName, Set<Address> addresses, Set<Phone> phones, Set<Bill> bills) {
		partnerManager.updatePartnerProfile(id, loginID, firstName, middleName, lastName, email, password, sellerLevel, sellerName, addresses, phones, bills);
		return "OK";
	}

	public String deletePartner(String id) {
		partnerManager.deletePartnerProfile(id);
		return "OK";
	}
	
	public PartnerRepresentation getPartnerByUsernameAndPassword(String id, String pwd) {
		
		Partner partner = partnerManager.getPartnerByUsernameAndPassword(id, pwd);
		
		PartnerRepresentation partnerRepresentation = new PartnerRepresentation();
		partnerRepresentation.setProfileID(partner.getProfileID());
		partnerRepresentation.setLoginID(partner.getLoginID());
		partnerRepresentation.setFirstName(partner.getFirstName());
		partnerRepresentation.setMiddleName(partner.getMiddleName());
		partnerRepresentation.setLastName(partner.getLastName());
		partnerRepresentation.setEmail(partner.getEmail());
		
		return partnerRepresentation;
	}

}
