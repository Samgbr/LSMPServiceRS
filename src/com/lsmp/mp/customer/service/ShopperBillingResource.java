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

import com.lsmp.mp.customer.service.representation.ShopperBillingRepresentation;
import com.lsmp.mp.customer.service.representation.ShopperBillingRequest;
import com.lsmp.mp.customer.service.workflow.ShopperBillingActivity;

@Path("/shopperbillingservice/")
public class ShopperBillingResource implements ShopperBillingService{

	@GET
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/shopperbilling/{billId}")
	public ShopperBillingRepresentation getShopperBillingInfo(@PathParam("billId") String id) {
		System.out.println("GET METHOD Request from Client with shopper billing request String ............." + id);
		ShopperBillingActivity shopperBillingActivity = new ShopperBillingActivity();
		return shopperBillingActivity.getShopperBillingInfo(id);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/shopperbilling")
	public ShopperBillingRepresentation insertShopperBillingInfo(ShopperBillingRequest shopperBillingRequest) {
		System.out.println("POST METHOD Shopper Billing Request from Client with ............." );		
		ShopperBillingActivity shopperBillingActivity = new ShopperBillingActivity();
		return shopperBillingActivity.insertShopperBillingInfo(shopperBillingRequest.getBillID(),shopperBillingRequest.getShopperProfileID()
				,shopperBillingRequest.getCreditCardNumber(),shopperBillingRequest.getCvv(),shopperBillingRequest.getExpiryMonth(),shopperBillingRequest.getExpiryYear());
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/shopperbilling")
	public Response updateShopperBillingInfo(ShopperBillingRequest shopperBillingRequest) {
		System.out.println("PUT METHOD Shopper Billing Request from Client with ............." );		
		ShopperBillingActivity shopperBillingActivity = new ShopperBillingActivity();
		String res = shopperBillingActivity.updateShopperBillingInfo(shopperBillingRequest.getBillID(),shopperBillingRequest.getShopperProfileID()
				,shopperBillingRequest.getCreditCardNumber(),shopperBillingRequest.getCvv(),shopperBillingRequest.getExpiryMonth(),shopperBillingRequest.getExpiryYear());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/shopperbilling/{billId}")
	public Response deleteShopperBillingInfo(@PathParam("billId") String id) {
		System.out.println("Delete METHOD Request from Client with Shopper Billing request String ............." + id);
		ShopperBillingActivity shopperBillingActivity = new ShopperBillingActivity();
		String res = shopperBillingActivity.deleteShopperBillingInfo(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/shopperbillings/{shopperProfileID}")
	public Set<ShopperBillingRepresentation> getShopperBillingInfos(@PathParam("shopperProfileID") String id) {
		System.out.println("GET METHOD Request for all Shopper Billing Infos .............");
		ShopperBillingActivity shopperBillingActivity = new ShopperBillingActivity();
		return shopperBillingActivity.getShopperBillingInfos(id);
	}

}
