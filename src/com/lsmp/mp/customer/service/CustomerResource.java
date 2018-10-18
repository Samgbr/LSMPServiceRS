package com.lsmp.mp.customer.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.lsmp.mp.customer.service.representation.CustomerRepresentation;
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
	
	
	
}
