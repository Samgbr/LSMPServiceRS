package com.lsmp.mp.customer;

import com.lsmp.dal.CustomerDAO;

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
	
}
