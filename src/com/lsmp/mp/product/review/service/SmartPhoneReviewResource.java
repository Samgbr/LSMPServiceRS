package com.lsmp.mp.product.review.service;

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


import com.lsmp.mp.product.review.service.representation.SmartPhoneReviewRepresentation;
import com.lsmp.mp.product.review.service.representation.SmartPhoneReviewRequest;
import com.lsmp.mp.product.review.service.workflow.SmartPhoneReviewActivity;

@Path("/smartphonereviewservice/")
public class SmartPhoneReviewResource implements SmartphoneReviewService {
	
	//GET,CREATE,DELETE AND UPDATE A Smart Phone Review
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/smartphonereviews")
	public Set<SmartPhoneReviewRepresentation> getAllSmartPhoneReviews(){
		System.out.println("GET METHOD Request for all Book Reviews .............");
		SmartPhoneReviewActivity smartPhoneReviewActiviy=new SmartPhoneReviewActivity();
		return smartPhoneReviewActiviy.getSmartPhoneReviews();
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/smartphonereview/{smartphoneproductId}/{profileId}")
	public SmartPhoneReviewRepresentation getBookReview(@PathParam("smartphoneproductId") String id, @PathParam("profileId") String pid) {
		System.out.println("GET METHOD Request from Client with smart phone review Request String :");
		SmartPhoneReviewActivity smartPhoneReviewActivity=new SmartPhoneReviewActivity();
		return smartPhoneReviewActivity.getSmartphoneReviewByProfileIDandProductID(id, pid);
		
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/smartphonereview")
	public SmartPhoneReviewRepresentation createSmartPhoneReview(SmartPhoneReviewRequest smartPhoneReviewRequest) {
		System.out.println("POST METHOD SmartPhone review Request from Client with ............." );
		SmartPhoneReviewActivity smartPhoneReviewActivity=new SmartPhoneReviewActivity();
		return smartPhoneReviewActivity.addSmartPhoneReview(smartPhoneReviewRequest.getProductReviewID(), smartPhoneReviewRequest.getSmartphoneProductID(), smartPhoneReviewRequest.getProfileID(), smartPhoneReviewRequest.getReview(), smartPhoneReviewRequest.getRating());
	}
	
	/**
	 * This method updates only review and rating
	 */
	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/smartphonereview")
	public Response updateSmartPhoneReview(SmartPhoneReviewRequest smartPhoneReviewRequest) {
		System.out.println("PUT METHOD smart phone Review Request from Client with ............." );
		SmartPhoneReviewActivity smartPhoneReviewActivity=new SmartPhoneReviewActivity();
		String res=smartPhoneReviewActivity.updateSmartPhoneReview(smartPhoneReviewRequest.getSmartphoneProductID(), smartPhoneReviewRequest.getProfileID(), smartPhoneReviewRequest.getReview(), smartPhoneReviewRequest.getRating());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/smartphonereview/{smartphoneproductId}")
	public Response deleteSmartPhoneReview(@PathParam("smartphoneproductId") String id) {
		System.out.println("Delete METHOD Request from Client with Smart Phone review Request String ............." + id);
		SmartPhoneReviewActivity smartPhoneReviewActivity=new SmartPhoneReviewActivity();
		String res = smartPhoneReviewActivity.deleteProductReview(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	

}
