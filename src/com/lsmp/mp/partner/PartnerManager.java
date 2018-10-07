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
	
	public Partner addPartnerProfile(String pid, String loginID, String firstName, String middleName, String lastName,
			String email,String password,String sellerLevel, String sellerName, Set<Address> addresses,Set<Phone> phones,Set<Bill> bills) {
		
		Partner partner = pDAO.addPartnerProfile(pid, loginID, firstName, middleName, lastName, email, password, sellerLevel,sellerName, addresses, phones,bills);
		
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
	public PartnerProduct getPartnerBookProfileBYProductID(String id) {
		return ppDAO.getPartnerBookProfileBYProductID(id);
	}
	
	public PartnerProduct getPartnerSmarphoneProfileBYProductID(String id) {
		return ppDAO.getPartnerSmarphoneProfileBYProductID(id);
	}
	
	public PartnerProduct addPartnerBook(String ppid, String id, String profileID) {
		
		PartnerProduct partnerProduct = ppDAO.addPartnerBook(ppid, id, profileID);
		
		return partnerProduct;
	}
	
	public PartnerProduct addPartnerSmartphone(String ppid, String id, String profileID) {
		
		PartnerProduct partnerProduct = ppDAO.addPartnerSmartphone(ppid, id, profileID);
		
		return partnerProduct;
	}
	
	public void updatePartnerBook(String id, String profileID) {
		ppDAO.updatePartnerBook(id, profileID);
	}
	
	public void updatePartnerSmartphone(String id, String profileID) {
		ppDAO.updatePartnerSmartphone(id, profileID);
	}
	
	public void deletePartnerBook(String id) {
		ppDAO.deletePartnerBook(id);
	}
	
	public void deletePartnerSmartphone(String id) {
		ppDAO.deletePartnerSmartphone(id);
	}
	
}
