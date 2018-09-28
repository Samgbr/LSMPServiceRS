package com.lsmp.mp.customer;

import java.util.Set;

import com.lsmp.dal.customer.CustomerDAO;

/**
 * Manager class for Customer Profile
 * @author samzi
 *
 */

public class CustomerManager {

	//Customer DAO
	private static CustomerDAO cDAO = new CustomerDAO();
	
	public Customer getCustomer(String id) {
		return cDAO.getCustomer(id);
	}
	
	public Customer addCustomer(String loginID, String firstName, String middleName, String lastName,
			String email,String password,String shopperType, Set<Address> addresses,Set<Phone> phones,Set<Bill> bills) {
		
		Customer customer = cDAO.addCustomer(loginID, firstName, middleName, lastName, email, password, shopperType, addresses, phones,bills);
		
		return customer;
	}

	public void updateCustomer(String id,String loginID, String firstName, String middleName, String lastName,
			String email,String password,String shopperType, Set<Address> addresses,Set<Phone> phones, Set<Bill> bills) {
		cDAO.updateCustomer(id, loginID, firstName, middleName, lastName, email, password, shopperType, addresses, phones,bills);
	}

	public void deleteCustomer(String id) {
		cDAO.deleteCustomer(id);
	}
	
}
