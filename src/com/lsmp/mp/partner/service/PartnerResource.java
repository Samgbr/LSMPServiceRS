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

import com.lsmp.mp.partner.service.representation.PartnerRepresentation;
import com.lsmp.mp.partner.service.representation.PartnerRequest;
import com.lsmp.mp.partner.service.workflow.PartnerActivity;

@Path("/partnerservice/")
public class PartnerResource implements PartnerService{

	@GET
	@Produces({"application/json"})
	@Path("/partners")
	public Set<PartnerRepresentation> getPartners() {
		System.out.println("GET METHOD Request for all Partners .............");
		PartnerActivity partnerActivity = new PartnerActivity();
		return partnerActivity.getPartners();
	}

	@GET
	@Produces({"application/json"})
	@Path("/partner/{profileId}")
	public PartnerRepresentation getPartner(@PathParam("profileId") String id) {
		System.out.println("GET METHOD Request from Client with Partner Request String ............." + id);
		PartnerActivity partnerActivity = new PartnerActivity();
		return partnerActivity.getPartner(id);
	}

	@POST
	@Produces({"application/json"})
	@Consumes({"application/json"})
	@Path("/partner")
	public PartnerRepresentation createPartner(PartnerRequest partnerRequest) {
		System.out.println("POST METHOD Partner Request from Client with ............." );		
		PartnerActivity partnerActivity = new PartnerActivity();
		return partnerActivity.createPartner(partnerRequest.getLoginID(),partnerRequest.getFirstName()
				, partnerRequest.getMiddleName(), partnerRequest.getLastName(), partnerRequest.getEmail(), partnerRequest.getPassword()
				, partnerRequest.getSellerLevel(),partnerRequest.getSellerName(),partnerRequest.getAddresses(),partnerRequest.getPhones(),partnerRequest.getBillingsInfo());
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partner")
	public Response updatePartner(PartnerRequest partnerRequest) {
		System.out.println("PUT METHOD Partner Request from Client with ............." );		
		PartnerActivity partnerActivity = new PartnerActivity();
		String res = partnerActivity.updatePartner(partnerRequest.getProfileID(),partnerRequest.getLoginID(),partnerRequest.getFirstName()
				, partnerRequest.getMiddleName(), partnerRequest.getLastName(), partnerRequest.getEmail(), partnerRequest.getPassword()
				, partnerRequest.getSellerLevel(),partnerRequest.getSellerName(),partnerRequest.getAddresses(),partnerRequest.getPhones(),partnerRequest.getBillingsInfo());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partner/{profileId}")
	public Response deletePartner(@PathParam("profileId") String id) {
		System.out.println("Delete METHOD Request from Client with Partner Request String ............." + id);
		PartnerActivity partnerActivity = new PartnerActivity();
		String res = partnerActivity.deletePartner(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@GET
	@Produces({"application/json"})
	@Path("/partner/{loginID}/{password}")
	public PartnerRepresentation getPartnerByUsernameAndPassword(@PathParam("loginID") String id,@PathParam("password") String pwd) {
		System.out.println("GET METHOD Request for Partner Username and Password .............");
		PartnerActivity partnerActivity = new PartnerActivity();
		return partnerActivity.getPartnerByUsernameAndPassword(id, pwd);
	}

	
}
