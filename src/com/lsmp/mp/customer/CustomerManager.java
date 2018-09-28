package com.lsmp.mp.customer;

import java.util.Set;

import com.lsmp.dal.customer.ShopperDAO;

/**
 * Manager class for Customer Profile
 * @author samzi
 *
 */

public class CustomerManager {

	//Shopper DAO
	private static ShopperDAO sDAO = new ShopperDAO();
	
	public Shopper getShopperProfile(String id) {
		return sDAO.getShopperProfile(id);
	}
	
	public Shopper addShopperProfile(String loginID, String firstName, String middleName, String lastName,
			String email,String password,String shopperType, Set<Address> addresses,Set<Phone> phones,Set<Bill> bills) {
		
		Shopper shopper = sDAO.addShopperProfile(loginID, firstName, middleName, lastName, email, password, shopperType, addresses, phones,bills);
		
		return shopper;
	}

	public void updateShopperProfile(String id,String loginID, String firstName, String middleName, String lastName,
			String email,String password,String shopperType, Set<Address> addresses,Set<Phone> phones, Set<Bill> bills) {
		sDAO.updateShopperProfile(id, loginID, firstName, middleName, lastName, email, password, shopperType, addresses, phones,bills);
	}

	public void deleteShopperProfile(String id) {
		sDAO.deleteShopperProfile(id);
	}
	
}
