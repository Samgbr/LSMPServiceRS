package com.lsmp.mp.product.review.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



import com.lsmp.mp.product.review.ProductReview;
import com.lsmp.mp.product.review.ProductReviewManager;
import com.lsmp.mp.product.review.service.representation.SmartPhoneReviewRepresentation;

public class SmartPhoneReviewActivity {
	public static ProductReviewManager productReviewManager=new ProductReviewManager();
	
	public Set<SmartPhoneReviewRepresentation> getSmartPhoneReviews(){
		
		Set<ProductReview> smartPhoneReviews=new HashSet<ProductReview>();
		Set<SmartPhoneReviewRepresentation> smartPhoneReviewRepresentations=new HashSet<SmartPhoneReviewRepresentation>();
		
		smartPhoneReviews=productReviewManager.getAllSmartPhoneReviews();
		Iterator<ProductReview> it=smartPhoneReviews.iterator();
		
		while(it.hasNext()) {
			
			ProductReview productReview = (ProductReview)it.next();
			
			SmartPhoneReviewRepresentation smartPhoneReviewRepresentation=new SmartPhoneReviewRepresentation();
			
			smartPhoneReviewRepresentation.setProductReviewID(productReview.getProductReviewID());
			smartPhoneReviewRepresentation.setSmartphoneProductID(productReview.getSmartphoneProductID());
			smartPhoneReviewRepresentation.setProfileID(productReview.getProfileID());
			smartPhoneReviewRepresentation.setReview(productReview.getReview());
			smartPhoneReviewRepresentation.setRating(productReview.getRating());
			
			  //now add this representation in the list
			smartPhoneReviewRepresentations.add(smartPhoneReviewRepresentation);
		}
		return smartPhoneReviewRepresentations;
	}

}
