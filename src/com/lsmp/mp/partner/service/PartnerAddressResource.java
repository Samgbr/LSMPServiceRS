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

import com.lsmp.mp.partner.service.representation.PartnerAddressRepresentation;
import com.lsmp.mp.partner.service.representation.PartnerAddressRequest;
import com.lsmp.mp.partner.service.workflow.PartnerAddressActivity;

@Path("/partneraddressservice/")
public class PartnerAddressResource implements PartnerAddressService{

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partneraddresses/{partnerProfileID}")
	public Set<PartnerAddressRepresentation> getPartnerAddresses(@PathParam("partnerProfileID") String id) {
		System.out.println("GET METHOD Request for all Partner Addresses .............");
		PartnerAddressActivity paaddressActivity = new PartnerAddressActivity();
		return paaddressActivity.getPartnerAddresses(id);
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partneraddress/{addressId}")
	public PartnerAddressRepresentation getPartnerAddress(@PathParam("addressId") String id) {
		System.out.println("GET METHOD Request from Client with Partner address request String ............." + id);
		PartnerAddressActivity paaddressActivity = new PartnerAddressActivity();
		return paaddressActivity.getPartnerAddress(id);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partneraddress")
	public PartnerAddressRepresentation createPartnerAddress(PartnerAddressRequest partnerAddressRequest) {
		System.out.println("POST METHOD Partner Address Request from Client with ............." );		
		PartnerAddressActivity paaddressActivity = new PartnerAddressActivity();
		return paaddressActivity.createPartnerAddress(partnerAddressRequest.getAddressID(), partnerAddressRequest.getPartnerProfileID()
				, partnerAddressRequest.getStreet(), partnerAddressRequest.getCity(), partnerAddressRequest.getState(), partnerAddressRequest.getZipcode());
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partneraddress")
	public Response updatePartnerAddress(PartnerAddressRequest partnerAddressRequest) {
		System.out.println("PUT METHOD Partner Address Request from Client with ............." );		
		PartnerAddressActivity paaddressActivity = new PartnerAddressActivity();
		String res = paaddressActivity.updatePartnerAddress(partnerAddressRequest.getAddressID(), partnerAddressRequest.getPartnerProfileID()
				, partnerAddressRequest.getStreet(), partnerAddressRequest.getCity(), partnerAddressRequest.getState(), partnerAddressRequest.getZipcode());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partneraddress/{addressId}")
	public Response deletePartnerAddress(@PathParam("addressId") String id) {
		System.out.println("Delete METHOD Request from Client with Partner Address request String ............." + id);
		PartnerAddressActivity paaddressActivity = new PartnerAddressActivity();
		String res = paaddressActivity.deletePartnerAddress(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

}
