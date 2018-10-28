package com.lsmp.mp.partner.service;

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

import com.lsmp.mp.partner.service.representation.PartnerBookRepresentation;
import com.lsmp.mp.partner.service.representation.PartnerBookRequest;
import com.lsmp.mp.partner.service.workflow.PartnerBookActivity;

@Path("/partnerbookservice/")
public class PartnerBookResource {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partnerbook/{productId}")
	public PartnerBookRepresentation getPartnerBookProfileBYProductID(@PathParam("productId") String id) {
		System.out.println("GET METHOD Request from Client with Partner Book Request String ............." + id);
		PartnerBookActivity partnerBookActivity=new PartnerBookActivity();
		return partnerBookActivity.getPartnerBookProfileBYProductID(id);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partnerbook")
	public PartnerBookRepresentation addPartnerBook(PartnerBookRequest partnerBookRequest) {
		System.out.println("POST METHOD Partner Book Request from Client with ............." );		
		PartnerBookActivity partnerBookActivity=new PartnerBookActivity();
		String pid = (String)partnerBookRequest.getPartnerProduct().keySet().toArray()[0];
		return partnerBookActivity.addPartnerBook(partnerBookRequest.getProductPartnerID(), pid, partnerBookRequest.getPartnerProduct().get(pid));
	}
	
	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partnerbook")
	public Response updatePartnerBook(PartnerBookRequest partnerBookRequest) {
		System.out.println("PUT METHOD Partner Book Request from Client with ............." );		
		PartnerBookActivity partnerBookActivity=new PartnerBookActivity();
		String pid = (String)partnerBookRequest.getPartnerProduct().keySet().toArray()[0];
		String res = partnerBookActivity.updatePartnerBook(pid, partnerBookRequest.getPartnerProduct().get(pid));
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/partnerbook/{productId}")
	public Response deletePartnerBook(@PathParam("productId") String id) {
		System.out.println("Delete METHOD Request from Client with Partner Book Request String ............." + id);
		PartnerBookActivity partnerBookActivity=new PartnerBookActivity();
		String res = partnerBookActivity.deletePartnerBook(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
}
