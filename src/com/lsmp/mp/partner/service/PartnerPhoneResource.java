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

import com.lsmp.mp.partner.service.representation.PartnerPhoneRepresentation;
import com.lsmp.mp.partner.service.representation.PartnerPhoneRequest;
import com.lsmp.mp.partner.service.workflow.PartnerPhoneActivity;

@Path("/partnerphoneservice/")
public class PartnerPhoneResource implements PartnerPhoneService{

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partnerphones/{partnerProfileID}")
	public Set<PartnerPhoneRepresentation> getPartnerPhones(@PathParam("partnerProfileID") String id) {
		System.out.println("GET METHOD Request for all Shopper Phones .............");
		PartnerPhoneActivity partnerPhoneActivity = new PartnerPhoneActivity();
		return partnerPhoneActivity.getShopperPhones(id);
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partnerphone/{phoneID}")
	public PartnerPhoneRepresentation getPartnerPhone(@PathParam("phoneID") String id) {
		System.out.println("GET METHOD Request from Client with Partner Phone request String ............." + id);
		PartnerPhoneActivity partnerPhoneActivity = new PartnerPhoneActivity();
		return partnerPhoneActivity.getPartnerPhone(id);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partnerphone")
	public PartnerPhoneRepresentation insertPartnerPhone(PartnerPhoneRequest partnerPhoneRequest) {
		System.out.println("POST METHOD Partner Phone Request from Client with ............." );		
		PartnerPhoneActivity partnerPhoneActivity = new PartnerPhoneActivity();
		return partnerPhoneActivity.insertPartnerPhone(partnerPhoneRequest.getPhoneID(), partnerPhoneRequest.getPartnerProfileID()
				, partnerPhoneRequest.getType(), partnerPhoneRequest.getPhoneNumber());
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partnerphone")
	public Response updatePartnerPhone(PartnerPhoneRequest partnerPhoneRequest) {
		System.out.println("PUT METHOD Partner Phone Request from Client with ............." );		
		PartnerPhoneActivity partnerPhoneActivity = new PartnerPhoneActivity();
		String res = partnerPhoneActivity.updatePartnerPhone(partnerPhoneRequest.getPhoneID(), partnerPhoneRequest.getPartnerProfileID()
				, partnerPhoneRequest.getType(), partnerPhoneRequest.getPhoneNumber());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partnerphone/{phoneId}")
	public Response deletePartnerPhone(@PathParam("phoneId") String id) {
		System.out.println("Delete METHOD Request from Client with Partner Phone request String ............." + id);
		PartnerPhoneActivity partnerPhoneActivity = new PartnerPhoneActivity();
		String res = partnerPhoneActivity.deletePartnerPhone(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

}
