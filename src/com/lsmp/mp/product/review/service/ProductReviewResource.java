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

import com.lsmp.mp.product.review.service.representation.ProductReviewRepresentation;
import com.lsmp.mp.product.review.service.representation.ProductReviewRequest;
import com.lsmp.mp.product.review.service.workflow.ProductReviewActivity;


@Path("/productreviewservice/")
public class ProductReviewResource implements ProductReviewService{
	//GET,CREATE,DELETE AND UPDATE A Book Review
	
	@GET
	@Produces({"application/json"})
	@Path("/productreviews/{productId}")
	public Set<ProductReviewRepresentation> getAllProductReviews(@PathParam("productId") String id){
		System.out.println("GET METHOD Request for all Product Reviews .............");
		ProductReviewActivity productReviewActivity=new ProductReviewActivity();
		return productReviewActivity.getProductReviews(id);
	}
	
	@GET
	@Produces({"application/json"})
	@Path("/productreview/{productId}")
	public ProductReviewRepresentation getProductReview(@PathParam("productId") String id) {
		System.out.println("GET METHOD Request from Client with Product review Request String :");
		ProductReviewActivity productReviewActivity=new ProductReviewActivity();
		return productReviewActivity.getProductReviewByProductID(id);
	}
	
	@POST
	@Produces({"application/json"})
	@Consumes({"application/json"})
	@Path("/productreview")
	public ProductReviewRepresentation createProductReview(ProductReviewRequest productReviewRequest) {
		System.out.println("POST METHOD Product review Request from Client with ............." );
		ProductReviewActivity productReviewActivity=new ProductReviewActivity();
		return productReviewActivity.addProductReview(productReviewRequest.getProductID(), productReviewRequest.getProfileID(), productReviewRequest.getReview(), productReviewRequest.getRating());
	}
	/**
	 * This method updates only review and rating
	 */
	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/productreview")
	public Response updateProductReview(ProductReviewRequest productReviewRequest) {
		System.out.println("PUT METHOD Product Review Request from Client with ............." );
		ProductReviewActivity productReviewActivity=new ProductReviewActivity();
		String res=productReviewActivity.updateProductReview(productReviewRequest.getProductID(), productReviewRequest.getProfileID(), productReviewRequest.getReview(), productReviewRequest.getRating());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/productreview/{productReviewId}")
	public Response deleteProductReview(@PathParam("productReviewId") String id) {
		System.out.println("Delete METHOD Request from Client with Product review Request String ............." + id);
		ProductReviewActivity productReviewActivity=new ProductReviewActivity();
		String res = productReviewActivity.deleteProductReview(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@GET
	@Produces({"application/json"})
	@Path("/productreview/{productId}/{ProfileID}")
	public ProductReviewRepresentation getProductReviewByProfileIDandProductID(@PathParam("productId") String id, @PathParam("ProfileID") String pid) {
		System.out.println("GET METHOD Request for all Product Reviews by profileID and productID.............");
		ProductReviewActivity productReviewActivity=new ProductReviewActivity();
		return productReviewActivity.getProductReviewByProfileIDandProductID(id, pid);
	}
	
	
}
