package com.lsmp.mp.partner.service;

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

import com.lsmp.mp.partner.service.representation.PartnerSmartphoneRepresentation;
import com.lsmp.mp.partner.service.representation.PartnerSmartphoneRequest;
import com.lsmp.mp.partner.service.workflow.PartnerSmartphoneActivity;

@Path("/partnersmartphoneservice/")
public class PartnerSmartphoneResource implements PartnerSmartphoneService{

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partnersmartphones")
	public Set<PartnerSmartphoneRepresentation> getAllPartnerSmartphones() {
		System.out.println("GET METHOD Request for all Partner Smartphones .............");
		PartnerSmartphoneActivity partnerSmartphoneActivity=new PartnerSmartphoneActivity();
		return partnerSmartphoneActivity.getAllPartnerSmartphones();
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partnersmartphone/{productId}")
	public PartnerSmartphoneRepresentation getPartnerSmarphoneProfileBYProductID(@PathParam("productId") String id) {
		System.out.println("GET METHOD Request from Client with Partner Smartphone Request String ............." + id);
		PartnerSmartphoneActivity partnerSmartphoneActivity=new PartnerSmartphoneActivity();
		return partnerSmartphoneActivity.getPartnerSmarphoneProfileBYProductID(id);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partnersmartphone")
	public PartnerSmartphoneRepresentation addPartnerSmartphone(PartnerSmartphoneRequest partnerSmartphoneRequest) {
		System.out.println("POST METHOD Partner Smartphone Request from Client with ............." );		
		PartnerSmartphoneActivity partnerSmartphoneActivity=new PartnerSmartphoneActivity();
		String pid = (String)partnerSmartphoneRequest.getPartnerProduct().keySet().toArray()[0];
		return partnerSmartphoneActivity.addPartnerSmartphone(partnerSmartphoneRequest.getProductPartnerID(), pid, partnerSmartphoneRequest.getPartnerProduct().get(pid));
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partnersmartphone")
	public Response updatePartnerSmartphone(PartnerSmartphoneRequest partnerSmartphoneRequest) {
		System.out.println("PUT METHOD Partner Smartphone Request from Client with ............." );		
		PartnerSmartphoneActivity partnerSmartphoneActivity=new PartnerSmartphoneActivity();
		String pid = (String)partnerSmartphoneRequest.getPartnerProduct().keySet().toArray()[0];
		String res = partnerSmartphoneActivity.updatePartnerSmartphone(pid, partnerSmartphoneRequest.getPartnerProduct().get(pid));
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partnersmartphone/{productId}")
	public Response deletePartnerSmartphone(@PathParam("productId") String id) {
		System.out.println("Delete METHOD Request from Client with Partner Smartphone Request String ............." + id);
		PartnerSmartphoneActivity partnerSmartphoneActivity=new PartnerSmartphoneActivity();
		String res = partnerSmartphoneActivity.deletePartnerSmartphone(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

}
