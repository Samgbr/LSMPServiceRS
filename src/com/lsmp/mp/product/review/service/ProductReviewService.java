package com.lsmp.mp.product.review.service;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.product.review.service.representation.ProductReviewRepresentation;
import com.lsmp.mp.product.review.service.representation.ProductReviewRequest;

@WebService
public interface ProductReviewService {
	//Book review representation and request methods goes here 
	
	public ProductReviewRepresentation getProductReview(String id);
	public Set<ProductReviewRepresentation> getAllProductReviews();
	public ProductReviewRepresentation createProductReview(ProductReviewRequest productReviewRequest);
	public Response updateProductReview(ProductReviewRequest productReviewRequest);
	public Response deleteProductReview(String productReviewID);
	
	

}
