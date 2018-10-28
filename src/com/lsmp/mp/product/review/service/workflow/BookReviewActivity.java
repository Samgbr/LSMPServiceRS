package com.lsmp.mp.product.review.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.mp.product.review.ProductReview;
import com.lsmp.mp.product.review.ProductReviewManager;
import com.lsmp.mp.product.review.service.representation.BookReviewRepresentation;

public class BookReviewActivity {
	
	public static ProductReviewManager productReviewManager=new ProductReviewManager();
	
	public Set<BookReviewRepresentation> getBookReviews(){
		
		Set<ProductReview> bookReviews=new HashSet<ProductReview>();
		Set<BookReviewRepresentation> bookReviewRepresentations=new HashSet<BookReviewRepresentation>();
		
		bookReviews=productReviewManager.getAllBookReviews();
		
		Iterator<ProductReview> it=bookReviews.iterator();
		
		while(it.hasNext()) {
			
			ProductReview productReview = (ProductReview)it.next();
			
			BookReviewRepresentation bookReviewRepresentation=new BookReviewRepresentation();
			
			bookReviewRepresentation.setProductReviewID(productReview.getProductReviewID());
			bookReviewRepresentation.setBookProductID(productReview.getBookProductID());
			bookReviewRepresentation.setProfileID(productReview.getProfileID());
			bookReviewRepresentation.setReview(productReview.getReview());
			bookReviewRepresentation.setRating(productReview.getRating());
			
			  //now add this representation in the list
			bookReviewRepresentations.add(bookReviewRepresentation);
		}
		return bookReviewRepresentations;
	}

}
