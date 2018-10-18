package com.lsmp.mp.customer.service;

import javax.jws.WebService;

import com.lsmp.mp.customer.service.representation.CustomerRepresentation;

@WebService
public interface CustomerService {
	
	//Shopper representation and request methods goes here
	public CustomerRepresentation getShopper(String shopperID);
}
