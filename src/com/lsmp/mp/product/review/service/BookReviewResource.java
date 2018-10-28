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

import com.lsmp.mp.product.review.service.representation.BookReviewRepresentation;
import com.lsmp.mp.product.review.service.representation.BookReviewRequest;
import com.lsmp.mp.product.review.service.workflow.BookReviewActivity;


@Path("/bookreviewservice/")
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
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/bookreview/{bookproductId}/{profileId}")
	public BookReviewRepresentation getBookReview(@PathParam("bookproductId") String id, @PathParam("profileId") String pid) {
		System.out.println("GET METHOD Request from Client with book review Request String :");
		BookReviewActivity bookReviewActivity=new BookReviewActivity();
		return bookReviewActivity.getBookReviewByProfileIDandProductID(id, pid);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/bookreview")
	public BookReviewRepresentation createBookReview(BookReviewRequest bookReviewRequest) {
		System.out.println("POST METHOD Book review Request from Client with ............." );
		BookReviewActivity bookReviewActivity=new BookReviewActivity();
		return bookReviewActivity.addBookReview(bookReviewRequest.getProductReviewID(), bookReviewRequest.getBookProductID(), bookReviewRequest.getProfileID(), bookReviewRequest.getProductReviewID(), bookReviewRequest.getRating());
	}
	
	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/bookreview")
	public Response updateBookReview(BookReviewRequest bookReviewRequest) {
		System.out.println("PUT METHOD Book Review Request from Client with ............." );
		BookReviewActivity bookReviewActivity=new BookReviewActivity();
		String res=bookReviewActivity.updateBookReview(bookReviewRequest.getProductReviewID(), bookReviewRequest.getBookProductID(), bookReviewRequest.getProfileID(), bookReviewRequest.getProductReviewID(), bookReviewRequest.getRating());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/bookreview/{bookproductId}")
	public Response deleteBookReview(@PathParam("bookproductId") String id) {
		System.out.println("Delete METHOD Request from Client with Book review Request String ............." + id);
		BookReviewActivity bookReviewActivity=new BookReviewActivity();
		String res = bookReviewActivity.deleteProductReview(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	
	
}
