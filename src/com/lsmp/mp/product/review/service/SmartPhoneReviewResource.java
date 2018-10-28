package com.lsmp.mp.product.review.service;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.lsmp.mp.product.review.service.representation.SmartPhoneReviewRepresentation;
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
	

}
