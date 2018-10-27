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

import com.lsmp.mp.partner.service.representation.PartnerBillingRepresentation;
import com.lsmp.mp.partner.service.representation.PartnerBillingRequest;
import com.lsmp.mp.partner.service.workflow.PartnerBillingActivity;

@Path("/partnerbillingservice/")
public class PartnerBillingResource implements PartnerBillingService{

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partnerbillings/{partnerProfileID}")
	public Set<PartnerBillingRepresentation> getPartnerBillingInfos(@PathParam("partnerProfileID") String id) {
		System.out.println("GET METHOD Request for all Partner Billing Infos .............");
		PartnerBillingActivity partnerBillingActivity = new PartnerBillingActivity();
		return partnerBillingActivity.getPartnerBillingInfos(id);
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partnerbilling/{billId}")
	public PartnerBillingRepresentation getPartnerBillingInfo(@PathParam("billId") String id) {
		System.out.println("GET METHOD Request from Client with Partner billing request String ............." + id);
		PartnerBillingActivity partnerBillingActivity = new PartnerBillingActivity();
		return partnerBillingActivity.getPartnerBillingInfo(id);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partnerbilling")
	public PartnerBillingRepresentation insertPartnerBillingInfo(PartnerBillingRequest partnerBillingRequest) {
		System.out.println("POST METHOD Partner Billing Request from Client with ............." );		
		PartnerBillingActivity partnerBillingActivity = new PartnerBillingActivity();
		return partnerBillingActivity.insertPartnerBillingInfo(partnerBillingRequest.getBillID(), partnerBillingRequest.getPartnerProfileID()
				, partnerBillingRequest.getCreditCardNumber(), partnerBillingRequest.getCvv(), partnerBillingRequest.getExpiryMonth(), partnerBillingRequest.getExpiryYear());
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partnerbilling")
	public Response updatePartnerBillingInfo(PartnerBillingRequest partnerBillingRequest) {
		System.out.println("PUT METHOD Partner Billing Request from Client with ............." );		
		PartnerBillingActivity partnerBillingActivity = new PartnerBillingActivity();
		String res = partnerBillingActivity.updatePartnerBillingInfo(partnerBillingRequest.getBillID(), partnerBillingRequest.getPartnerProfileID()
				, partnerBillingRequest.getCreditCardNumber(), partnerBillingRequest.getCvv(), partnerBillingRequest.getExpiryMonth(), partnerBillingRequest.getExpiryYear());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partnerbilling/{billId}")
	public Response deletePartnerBillingInfo(@PathParam("billId") String id) {
		System.out.println("Delete METHOD Request from Client with Partner Billing request String ............." + id);
		PartnerBillingActivity partnerBillingActivity = new PartnerBillingActivity();
		String res = partnerBillingActivity.deletePartnerBillingInfo(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

}
