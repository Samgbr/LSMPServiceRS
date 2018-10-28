package com.lsmp.mp.product.review.service;

import java.util.Set;

import javax.ws.rs.core.Response;

import com.lsmp.mp.product.review.service.representation.SmartPhoneReviewRepresentation;
import com.lsmp.mp.product.review.service.representation.SmartPhoneReviewRequest;



public interface SmartphoneReviewService {
	//SmartPhone review representation and request methods goes here 
	
	//public SmartPhoneReviewRepresentation getSmartPhoneReview(String id, String pid);
	public Set<SmartPhoneReviewRepresentation> getAllSmartPhoneReviews();
	//public SmartPhoneReviewRepresentation createSmartPhoneReview(SmartPhoneReviewRequest smartPhoneReviewRequest);
	//public Response updateSmartPhoneReview(SmartPhoneReviewRequest smartPhoneReviewRequest);
	//public Response deleteSmartPhoneReview(String productReviewID);

}
