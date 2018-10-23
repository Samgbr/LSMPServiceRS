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

import com.lsmp.mp.customer.service.representation.ShopperAddressRepresentation;
import com.lsmp.mp.customer.service.representation.ShopperAddressRequest;
import com.lsmp.mp.customer.service.workflow.ShopperAddressActivity;

@Path("/shopperaddressservice/")
public class ShopperAddressResource implements ShopperAddressService{

		//GET, CREATE, UPDATE and DELETE Shopper
		@GET
		@Produces({"application/xml" , "application/json"})
		@Consumes({"application/xml", "application/json"})
		@Path("/shopperaddress/{addressId}")
		public ShopperAddressRepresentation getShopperAddress(@PathParam("addressId") String id) {
			System.out.println("GET METHOD Request from Client with shopper address request String ............." + id);
			ShopperAddressActivity shaddressActivity = new ShopperAddressActivity();
			return shaddressActivity.getShopperAddress(id);
		}

		@POST
		@Produces({"application/xml" , "application/json"})
		@Consumes({"application/xml", "application/json"})
		@Path("/shopperaddress")
		public ShopperAddressRepresentation createShopperAddress(ShopperAddressRequest shopperAddressRequest) {
			System.out.println("POST METHOD Shopper Address Request from Client with ............." );		
			ShopperAddressActivity shaddressActivity = new ShopperAddressActivity();
			return shaddressActivity.createShopperAddress(shopperAddressRequest.getAddressID(),shopperAddressRequest.getShopperProfileID()
					,shopperAddressRequest.getStreet(),shopperAddressRequest.getCity(),shopperAddressRequest.getState(),shopperAddressRequest.getZipcode());
		}

		@PUT
		@Produces({"application/xml" , "application/json"})
		@Consumes({"application/xml", "application/json"})
		@Path("/shopperaddress")
		public Response updateShopperAddress(ShopperAddressRequest shaddressRequest) {
			System.out.println("PUT METHOD Shopper Address Request from Client with ............." );		
			ShopperAddressActivity shaddressActivity = new ShopperAddressActivity();
			String res = shaddressActivity.updateShopperAddress(shaddressRequest.getAddressID(),shaddressRequest.getShopperProfileID()
					,shaddressRequest.getStreet(),shaddressRequest.getCity(),shaddressRequest.getState(),shaddressRequest.getZipcode());
			if (res.equals("OK")) {
				return Response.status(Status.OK).build();
			}
			return null;
		}

		@DELETE
		@Produces({"application/xml" , "application/json"})
		@Consumes({"application/xml", "application/json"})
		@Path("/shopperaddress/{addressId}")
		public Response deleteShopperAddress(@PathParam("addressId") String id) {
			System.out.println("Delete METHOD Request from Client with Shopper Address request String ............." + id);
			ShopperAddressActivity shaddressActivity = new ShopperAddressActivity();
			String res = shaddressActivity.deleteShopperAddress(id);
			if (res.equals("OK")) {
				return Response.status(Status.OK).build();
			}
			return null;
		}
}
