package com.lsmp.mp.product.review.service;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.product.review.service.representation.BookReviewRepresentation;
import com.lsmp.mp.product.review.service.representation.BookReviewRequest;

@WebService
public interface BookReviewService {
	//Book review representation and request methods goes here 
	
	public BookReviewRepresentation getBookReview(String id, String pid);
	public Set<BookReviewRepresentation> getAllBookReviews();
	public BookReviewRepresentation createBookReview(BookReviewRequest bookReviewRequest);
	public Response updateBookReview(BookReviewRequest bookReviewRequest);
	public Response deleteBookReview(String productReviewID);
	
	

}
