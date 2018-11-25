package com.lsmp.mp.customer.service;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.customer.service.representation.CustomerRepresentation;
import com.lsmp.mp.customer.service.representation.CustomerRequest;

@WebService
public interface CustomerService {
	
	//Shopper representation and request methods goes here
	public Set<CustomerRepresentation> getShoppers();
	public CustomerRepresentation getShopper(String shopperID);
	public CustomerRepresentation getShopperByUsernameAndPassword(String id, String pwd);
	public CustomerRepresentation createShopper(CustomerRequest customerRequest);
	public Response updateShopper(CustomerRequest customerRequest);
    public Response deleteShopper(String profileId);
}
