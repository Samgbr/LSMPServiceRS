package com.lsmp.mp.product.service;

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

import com.lsmp.mp.product.service.representation.SmartphoneRepresentation;
import com.lsmp.mp.product.service.representation.SmartphoneRequest;
import com.lsmp.mp.product.service.workflow.SmartphoneActivity;

@Path("/smartphoneservice/")
public class SmartphoneResource implements SmartphoneService{

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/smartphone/{productId}")
	public SmartphoneRepresentation getSmartphone(@PathParam("productId") String id) {
		System.out.println("GET METHOD Request from Client with Smartphone Request String ............." + id);
		SmartphoneActivity smartphoneActivity=new SmartphoneActivity();
		return smartphoneActivity.getSmartphone(id);
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/smartphones")
	public Set<SmartphoneRepresentation> getSmartphones() {
		System.out.println("GET METHOD Request for all Smartphones .............");
		SmartphoneActivity smartphoneActivity=new SmartphoneActivity();
		return smartphoneActivity.getSmartphones();
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/smartphone")
	public SmartphoneRepresentation createSmartphone(SmartphoneRequest smartphoneRequest) {
		System.out.println("POST METHOD Smartphone Request from Client with ............." );		
		SmartphoneActivity smartphoneActivity=new SmartphoneActivity();
		return smartphoneActivity.createSmartphone(smartphoneRequest.getProductID(), smartphoneRequest.getPurchasePrice(), smartphoneRequest.getSellingPrice(), smartphoneRequest.getDisplayInch()
				, smartphoneRequest.getBrand(), smartphoneRequest.getRamSize(), smartphoneRequest.getOs(), smartphoneRequest.getStorageSize());
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/smartphone")
	public Response updateSmartphone(SmartphoneRequest smartphoneRequest) {
		System.out.println("PUT METHOD Smartphone Request from Client with ............." );		
		SmartphoneActivity smartphoneActivity=new SmartphoneActivity();
		String res = smartphoneActivity.updateSmartphone(smartphoneRequest.getProductID(), smartphoneRequest.getPurchasePrice(), smartphoneRequest.getSellingPrice(), smartphoneRequest.getDisplayInch()
				, smartphoneRequest.getBrand(), smartphoneRequest.getRamSize(), smartphoneRequest.getOs(), smartphoneRequest.getStorageSize());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/smartphone/{productId}")
	public Response deleteSmartphone(@PathParam("productId") String id) {
		System.out.println("Delete METHOD Request from Client with Smartphone Request String ............." + id);
		SmartphoneActivity smartphoneActivity=new SmartphoneActivity();
		String res = smartphoneActivity.deleteSmartphone(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

}
