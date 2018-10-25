package com.lsmp.mp.customer.service;

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

import com.lsmp.mp.customer.service.representation.ShopperPhoneRepresentation;
import com.lsmp.mp.customer.service.representation.ShopperPhoneRequest;
import com.lsmp.mp.customer.service.workflow.ShopperPhoneActivity;

@Path("/shopperphoneservice/")
public class ShopperPhoneResource implements ShopperPhoneService{

	@GET
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/shopperphone/{phoneID}")
	public ShopperPhoneRepresentation getShopperPhone(String id) {
		System.out.println("GET METHOD Request from Client with shopper Phone request String ............." + id);
		ShopperPhoneActivity shopperPhoneActivity = new ShopperPhoneActivity();
		return shopperPhoneActivity.getShopperPhone(id);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/shopperphone")
	public ShopperPhoneRepresentation insertShopperPhone(ShopperPhoneRequest shopperPhoneRequest) {
		System.out.println("POST METHOD Shopper Phone Request from Client with ............." );		
		ShopperPhoneActivity shopperPhoneActivity = new ShopperPhoneActivity();
		return shopperPhoneActivity.insertShopperPhone(shopperPhoneRequest.getPhoneID(), shopperPhoneRequest.getShopperProfileID()
				, shopperPhoneRequest.getType(), shopperPhoneRequest.getPhoneNumber());
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/shopperphone")
	public Response updateShopperPhone(ShopperPhoneRequest shopperPhoneRequest) {
		System.out.println("PUT METHOD Shopper Phone Request from Client with ............." );		
		ShopperPhoneActivity shopperPhoneActivity = new ShopperPhoneActivity();
		String res = shopperPhoneActivity.updateShopperPhone(shopperPhoneRequest.getPhoneID(), shopperPhoneRequest.getShopperProfileID()
				, shopperPhoneRequest.getType(), shopperPhoneRequest.getPhoneNumber());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/shopperphone/{phoneId}")
	public Response deleteShopperPhone(@PathParam("phoneId") String id) {
		System.out.println("Delete METHOD Request from Client with Shopper Phone request String ............." + id);
		ShopperPhoneActivity shopperPhoneActivity = new ShopperPhoneActivity();
		String res = shopperPhoneActivity.deleteShopperPhone(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

}
