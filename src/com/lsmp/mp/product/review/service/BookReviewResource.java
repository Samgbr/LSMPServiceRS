package com.lsmp.mp.product.review.service;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.lsmp.mp.product.review.service.representation.BookReviewRepresentation;
import com.lsmp.mp.product.review.service.workflow.BookReviewActivity;

@Path("/bookreviewservice")
public class BookReviewResource implements BookReviewService{
	//GET,CREATE,DELETE AND UPDATE A Book Review
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/bookreviews")
	public Set<BookReviewRepresentation> getAllBookReviews(){
		System.out.println("GET METHOD Request for all Book Reviews .............");
		BookReviewActivity bookReviewActivity=new BookReviewActivity();
		return bookReviewActivity.getBookReviews();
	}
}
