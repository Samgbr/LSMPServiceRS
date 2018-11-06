package com.lsmp.mp.partner;

import java.util.Set;

import com.lsmp.dal.partner.PartnerDAO;
import com.lsmp.mp.customer.Address;
import com.lsmp.mp.customer.Bill;
import com.lsmp.mp.customer.Phone;

public class PartnerManager {

private static PartnerDAO pDAO = new PartnerDAO();
	
	public Partner getPartnerProfile(String id) {
		return pDAO.getPartnerProfile(id);
	}
	
	public Set<Partner> getAllPartnerProfiles() {
		return pDAO.getAllPartnerProfiles();
	}
	
	public Set<Partner> getAllPartner() {
		return pDAO.getAllPartner();
	}
	
	public Partner getPartner(String id) {
		return pDAO.getPartner(id);
	}
	
	public Partner addPartnerProfile(String pid, String loginID, String firstName, String middleName, String lastName,
			String email,String password,String sellerLevel, String sellerName, Set<Address> addresses,Set<Phone> phones,Set<Bill> bills) {
		
		Partner partner = pDAO.addPartnerProfile(pid, loginID, firstName, middleName, lastName, email, password, sellerLevel,sellerName, addresses, phones,bills);
		
		return partner;
	}
	
	public Partner addPartner(String pid, String loginID, String firstName, String middleName, String lastName,
			String email,String password,String sellerLevel, String sellerName) {
		
		Partner partner = pDAO.addPartner(pid, loginID, firstName, middleName, lastName, email, password, sellerLevel,sellerName);
		
		return partner;
	}

	public void updatePartnerProfile(String id,String loginID, String firstName, String middleName, String lastName,
			String email,String password,String sellerLevel, String sellerName, Set<Address> addresses,Set<Phone> phones, Set<Bill> bills) {
		pDAO.updatePartnerProfile(id, loginID, firstName, middleName, lastName, email, password, sellerLevel,sellerName, addresses, phones,bills);
	}
	
	public void updatePartner(String id,String loginID, String firstName, String middleName, String lastName,
			String email,String password,String sellerLevel, String sellerName) {
		pDAO.updatePartner(id, loginID, firstName, middleName, lastName, email, password, sellerLevel,sellerName);
	}

	public void deletePartnerProfile(String id) {
		pDAO.deletePartnerProfile(id);
	}
	
	public void deletePartner(String id) {
		pDAO.deletePartner(id);
	}
	
	//------------------------------------------
	// Partner product removed
	
}
