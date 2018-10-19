package com.lsmp.mp.customer.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.lsmp.mp.customer.service.representation.CustomerRepresentation;
import com.lsmp.mp.customer.service.representation.CustomerRequest;
import com.lsmp.mp.customer.service.workflow.CustomerActivity;

@Path("/shopperservice/")
public class CustomerResource implements CustomerService {
	
	//GET, CREATE, UPDATE and DELETE Shopper
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/shopper/{shopperId}")
	public CustomerRepresentation getShopper(@PathParam("shopperId") String id) {
		System.out.println("GET METHOD Request from Client with shopperRequest String ............." + id);
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.getShopper(id);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/shopper")
	public CustomerRepresentation createShopper(CustomerRequest customerRequest) {
		System.out.println("POST METHOD Customer Request from Client with ............." );		
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.createShopper(customerRequest.getProfileID(),customerRequest.getLoginID(),customerRequest.getFirstName()
				, customerRequest.getMiddleName(), customerRequest.getLastName(), customerRequest.getEmail(), customerRequest.getPassword()
				, customerRequest.getShopperType());
		
	}
	
	
	
}
