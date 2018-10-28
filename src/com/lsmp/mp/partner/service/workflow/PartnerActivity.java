package com.lsmp.mp.partner.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.mp.partner.Partner;
import com.lsmp.mp.partner.PartnerManager;
import com.lsmp.mp.partner.service.representation.PartnerRepresentation;

public class PartnerActivity {

	private static PartnerManager partnerManager = new PartnerManager();
	
	public PartnerRepresentation getPartner(String id) {
		
		Partner partner = partnerManager.getPartner(id);
		
		PartnerRepresentation partnerRepresentation = new PartnerRepresentation();
		partnerRepresentation.setProfileID(partner.getProfileID());
		partnerRepresentation.setLoginID(partner.getLoginID());
		partnerRepresentation.setFirstName(partner.getFirstName());
		partnerRepresentation.setMiddleName(partner.getMiddleName());
		partnerRepresentation.setLastName(partner.getLastName());
		partnerRepresentation.setEmail(partner.getEmail());
		partnerRepresentation.setSellerLevel(partner.getSellerLevel());
		partnerRepresentation.setSellerName(partner.getSellerName());
		
		return partnerRepresentation;
	}

	public Set<PartnerRepresentation> getPartners() {
		
		Set<Partner> partners = new HashSet<Partner>();
		Set<PartnerRepresentation> partnerRepresentations = new HashSet<PartnerRepresentation>();
		
		partners = partnerManager.getAllPartner();
		
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
          
          //now add this representation in the list
          partnerRepresentations.add(partnerRepresentation);
        }
		return partnerRepresentations;
	}

	public PartnerRepresentation createPartner(String pid, String loginID, String firstName, String middleName,
			String lastName, String email, String password, String sellerLevel, String sellerName) {
		
		Partner partner = partnerManager.addPartner(pid, loginID, firstName, middleName, lastName, email, password, sellerLevel, sellerName);
		
		PartnerRepresentation partnerRepresentation = new PartnerRepresentation();
        partnerRepresentation.setProfileID(partner.getProfileID());
        partnerRepresentation.setLoginID(partner.getLoginID());
        partnerRepresentation.setFirstName(partner.getFirstName());
        partnerRepresentation.setMiddleName(partner.getMiddleName());
        partnerRepresentation.setLastName(partner.getLastName());
        partnerRepresentation.setEmail(partner.getEmail());
        partnerRepresentation.setSellerLevel(partner.getSellerLevel());
        partnerRepresentation.setSellerName(partner.getSellerName());
        
		return partnerRepresentation;
	}

	public String updatePartner(String id, String loginID, String firstName, String middleName, String lastName,
			String email, String password, String sellerLevel, String sellerName) {
		partnerManager.updatePartner(id, loginID, firstName, middleName, lastName, email, password, sellerLevel, sellerName);
		return "OK";
	}

	public String deletePartner(String id) {
		partnerManager.deletePartner(id);
		return "OK";
	}

}
