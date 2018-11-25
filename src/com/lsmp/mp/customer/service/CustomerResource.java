package com.lsmp.mp.customer.service;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.lsmp.mp.customer.service.representation.CustomerRepresentation;
import com.lsmp.mp.customer.service.representation.CustomerRequest;
import com.lsmp.mp.customer.service.workflow.CustomerActivity;

@Path("/shopperservice/")
public class CustomerResource implements CustomerService {
	
	//GET, CREATE, UPDATE and DELETE Shopper
	@GET
	@Produces({"application/json"})
	@Path("/shopper/{shopperId}")
	public CustomerRepresentation getShopper(@PathParam("shopperId") String id) {
		System.out.println("GET METHOD Request from Client with shopperRequest String ............." + id);
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.getShopper(id);
	}

	@POST
	//@Produces({"application/json"})
	@Consumes({"application/json"})
	@Path("/shopper")
	public CustomerRepresentation createShopper(CustomerRequest customerRequest) {
		System.out.println("POST METHOD Customer Request from Client with ............." );		
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.createShopper(customerRequest.getLoginID(),customerRequest.getFirstName()
				, customerRequest.getMiddleName(), customerRequest.getLastName(), customerRequest.getEmail(), customerRequest.getPassword()
				, customerRequest.getShopperType(),customerRequest.getAddresses(),customerRequest.getPhones(),customerRequest.getBills());
	}

	
	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/shopper")
	public Response updateShopper(CustomerRequest customerRequest) {
		System.out.println("PUT METHOD Customer Request from Client with ............." );		
		CustomerActivity customerActivity = new CustomerActivity();
		String res = customerActivity.updateShopper(customerRequest.getProfileID(),customerRequest.getLoginID(),customerRequest.getFirstName()
				, customerRequest.getMiddleName(), customerRequest.getLastName(), customerRequest.getEmail(), customerRequest.getPassword()
				, customerRequest.getShopperType(),customerRequest.getAddresses(),customerRequest.getPhones(),customerRequest.getBills());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/shopper/{shopperId}")
	public Response deleteShopper(@PathParam("shopperId") String id) {
		System.out.println("Delete METHOD Request from Client with customerRequest String ............." + id);
		CustomerActivity customerActivity = new CustomerActivity();
		String res = customerActivity.deleteShopper(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/shoppers")
	public Set<CustomerRepresentation> getShoppers() {
		System.out.println("GET METHOD Request for all Shoppers .............");
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.getShoppers();
	}

	@GET
	@Produces({"application/json"})
	@Path("/shopper/{loginID}/{password}")
	public CustomerRepresentation getShopperByUsernameAndPassword(@PathParam("loginID") String id, @PathParam("password") String pwd) {
		System.out.println("GET METHOD Request from Client with username and password String ............." + id);
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.getShopperByUsernameAndPassword(id, pwd);
	}
	
	
	
}
