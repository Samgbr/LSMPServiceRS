package com.lsmp.mp.partner;

import java.util.Set;

import com.lsmp.dal.partner.PartnerDAO;
import com.lsmp.dal.partner.PartnerProductDAO;
import com.lsmp.mp.customer.Address;
import com.lsmp.mp.customer.Bill;
import com.lsmp.mp.customer.Phone;

public class PartnerManager {

private static PartnerDAO pDAO = new PartnerDAO();
private static PartnerProductDAO ppDAO = new PartnerProductDAO();
	
	public Partner getPartnerProfile(String id) {
		return pDAO.getPartnerProfile(id);
	}
	
	public Partner addPartnerProfile(String loginID, String firstName, String middleName, String lastName,
			String email,String password,String sellerLevel, String sellerName, Set<Address> addresses,Set<Phone> phones,Set<Bill> bills) {
		
		Partner partner = pDAO.addPartnerProfile(loginID, firstName, middleName, lastName, email, password, sellerLevel,sellerName, addresses, phones,bills);
		
		return partner;
	}

	public void updatePartnerProfile(String id,String loginID, String firstName, String middleName, String lastName,
			String email,String password,String sellerLevel, String sellerName, Set<Address> addresses,Set<Phone> phones, Set<Bill> bills) {
		pDAO.updatePartnerProfile(id, loginID, firstName, middleName, lastName, email, password, sellerLevel,sellerName, addresses, phones,bills);
	}

	public void deletePartnerProfile(String id) {
		pDAO.deletePartnerProfile(id);
	}
	
	//------------------------------------------
	public PartnerProduct getPartnerProductProfileBYProductID(String id) {
		return ppDAO.getPartnerProductProfileBYProductID(id);
	}
	
	public PartnerProduct addPartnerProduct(String id, String profileID) {
		
		PartnerProduct partnerProduct = ppDAO.addPartnerProduct(id, profileID);
		
		return partnerProduct;
	}
	
	public void updatePartnerProduct(String id, String profileID) {
		ppDAO.updatePartnerProduct(id, profileID);
	}
	
	public void deletePartnerProduct(String id) {
		ppDAO.deletePartnerProduct(id);
	}
	
}
