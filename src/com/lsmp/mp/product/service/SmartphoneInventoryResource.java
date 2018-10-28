package com.lsmp.mp.product.service;

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

import com.lsmp.mp.product.service.representation.SmartphoneInventoryRepresentation;
import com.lsmp.mp.product.service.representation.SmartphoneInventoryRequest;
import com.lsmp.mp.product.service.workflow.SmartphoneInventoryActivity;

@Path("/smartphoneinventoryservice/")
public class SmartphoneInventoryResource implements SmartphoneInventoryService{

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/smartphoneinventory/{productId}")
	public SmartphoneInventoryRepresentation getSmartphoneQtyOnHand(@PathParam("productId") String id) {
		System.out.println("GET METHOD Request from Client with Smartphone Inventory Request String ............." + id);
		SmartphoneInventoryActivity smartphoneInventoryActivity=new SmartphoneInventoryActivity();
		return smartphoneInventoryActivity.getSmartphoneQtyOnHand(id);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/smartphoneinventory")
	public SmartphoneInventoryRepresentation createSmartphoneInventory(SmartphoneInventoryRequest smartphoneInventoryRequest) {
		System.out.println("POST METHOD Smartphone Inventory Request from Client with ............." );		
		SmartphoneInventoryActivity smartphoneInventoryActivity=new SmartphoneInventoryActivity();
		String pid = (String)smartphoneInventoryRequest.getQtyOnHandMap().keySet().toArray()[0];
		return smartphoneInventoryActivity.createSmartphoneInventory(smartphoneInventoryRequest.getInventoryID(), pid, smartphoneInventoryRequest.getQtyOnHandMap().get(pid));
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/smartphoneinventory")
	public Response updateSmartphoneInventory(SmartphoneInventoryRequest smartphoneInventoryRequest) {
		System.out.println("PUT METHOD Smartphone Inventory Request from Client with ............." );		
		SmartphoneInventoryActivity smartphoneInventoryActivity=new SmartphoneInventoryActivity();
		String pid = (String)smartphoneInventoryRequest.getQtyOnHandMap().keySet().toArray()[0];
		String res = smartphoneInventoryActivity.updateSmartphoneInventory(pid, smartphoneInventoryRequest.getQtyOnHandMap().get(pid));
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/smartphoneinventory/{productId}")
	public Response deleteSmartphoneInventory(@PathParam("productId") String id) {
		System.out.println("Delete METHOD Request from Client with Smartphone Inventory Request String ............." + id);
		SmartphoneInventoryActivity smartphoneInventoryActivity=new SmartphoneInventoryActivity();
		String res = smartphoneInventoryActivity.deleteSmartphoneInventory(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

}
