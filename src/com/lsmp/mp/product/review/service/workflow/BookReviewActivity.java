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
	
	public BookReviewRepresentation getBookReviewByProfileIDandProductID(String id, String pid) {
		ProductReview productReview=productReviewManager.getBookReviewByProfileIDandProductID(id, pid);
		
		BookReviewRepresentation bookReviewRepresentation=new BookReviewRepresentation();
		
		bookReviewRepresentation.setProductReviewID(productReview.getProductReviewID());
		bookReviewRepresentation.setBookProductID(productReview.getBookProductID());
		bookReviewRepresentation.setProfileID(productReview.getProfileID());
		bookReviewRepresentation.setReview(productReview.getReview());
		bookReviewRepresentation.setRating(productReview.getRating());
		
		return bookReviewRepresentation;
	}
	
	public BookReviewRepresentation addBookReview(String id,String pid,String prid, String review,double rating) {
		ProductReview productReview=productReviewManager.addBookReview(id, pid, prid, review, rating);
		
		BookReviewRepresentation bookReviewRepresentation=new BookReviewRepresentation();
		
		bookReviewRepresentation.setProductReviewID(productReview.getProductReviewID());
		bookReviewRepresentation.setBookProductID(productReview.getBookProductID());
		bookReviewRepresentation.setProfileID(productReview.getProfileID());
		bookReviewRepresentation.setReview(productReview.getReview());
		bookReviewRepresentation.setRating(productReview.getRating());
		
		return bookReviewRepresentation;
	}
	
	public String updateBookReview(String prid,String pid, String review,double rating) {
		productReviewManager.updateBookReview(prid, pid, review, rating);
		return "OK";
	}
	
	public String deleteProductReview(String id) {
		productReviewManager.deleteProductReview(id);
		return "OK";
	}

}
