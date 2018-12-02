package com.lsmp.mp.product.review.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.mp.link.Link;
import com.lsmp.mp.product.review.ProductReview;
import com.lsmp.mp.product.review.ProductReviewManager;
import com.lsmp.mp.product.review.service.representation.ProductReviewRepresentation;

public class ProductReviewActivity {
	
	public static ProductReviewManager productReviewManager=new ProductReviewManager();
	
	public Set<ProductReviewRepresentation> getProductReviews(String id){
		
		Set<ProductReview> productReviews=new HashSet<ProductReview>();
		Set<ProductReviewRepresentation> productReviewRepresentations=new HashSet<ProductReviewRepresentation>();
		
		productReviews=productReviewManager.getAllProductReviews(id);
		
		Iterator<ProductReview> it=productReviews.iterator();
		
		while(it.hasNext()) {
			
			ProductReview productReview = (ProductReview)it.next();
			
			ProductReviewRepresentation productReviewRepresentation=new ProductReviewRepresentation();
			
			productReviewRepresentation.setProductReviewID(productReview.getProductReviewID());
			productReviewRepresentation.setProductID(productReview.getProductID());
			productReviewRepresentation.setProfileID(productReview.getProfileID());
			productReviewRepresentation.setReview(productReview.getReview());
			productReviewRepresentation.setRating(productReview.getRating());
			
			  //now add this representation in the list
			productReviewRepresentations.add(productReviewRepresentation);
		}
		return productReviewRepresentations;
	}
	
	public ProductReviewRepresentation getProductReviewByProductID(String id) {
		ProductReview productReview=productReviewManager.getProductReviewByProductID(id);
		
		ProductReviewRepresentation productReviewRepresentation=new ProductReviewRepresentation();
		
		productReviewRepresentation.setProductReviewID(productReview.getProductReviewID());
		productReviewRepresentation.setProductID(productReview.getProductID());
		productReviewRepresentation.setProfileID(productReview.getProfileID());
		productReviewRepresentation.setReview(productReview.getReview());
		productReviewRepresentation.setRating(productReview.getRating());
		setLinks(productReviewRepresentation);
		return productReviewRepresentation;
	}
	
	public ProductReviewRepresentation getProductReviewByProfileIDandProductID(String id, String pid) {
		ProductReview productReview=productReviewManager.getProductReviewByProfileIDandProductID(id, pid);
		
		ProductReviewRepresentation productReviewRepresentation=new ProductReviewRepresentation();
		
		productReviewRepresentation.setProductReviewID(productReview.getProductReviewID());
		productReviewRepresentation.setProductID(productReview.getProductID());
		productReviewRepresentation.setProfileID(productReview.getProfileID());
		productReviewRepresentation.setReview(productReview.getReview());
		productReviewRepresentation.setRating(productReview.getRating());
		
		return productReviewRepresentation;
	}
	
	public ProductReviewRepresentation addProductReview(String pid,String prid, String review,double rating) {
		ProductReview productReview=productReviewManager.addProductReview(pid, prid, review, rating);
		
		ProductReviewRepresentation productReviewRepresentation=new ProductReviewRepresentation();
		
		productReviewRepresentation.setProductReviewID(productReview.getProductReviewID());
		productReviewRepresentation.setProductID(productReview.getProductID());
		productReviewRepresentation.setProfileID(productReview.getProfileID());
		productReviewRepresentation.setReview(productReview.getReview());
		productReviewRepresentation.setRating(productReview.getRating());
		
		return productReviewRepresentation;
	}
	
	private void setLinks(ProductReviewRepresentation productReviewRepresentation) {
		Link updatereview = new Link("updatereview", 
				"http://localhost:8082/ProductReview/productreviewservice/productreview" ,"application/xml");
		Link deletereview = new Link("deletereview", 
				"http://localhost:8082/ProductReview/productreviewservice/productreview/" + productReviewRepresentation.getProductReviewID() ,"application/xml");
		productReviewRepresentation.setLinks(updatereview,deletereview);
	}

	public String updateProductReview(String prid,String pid, String review,double rating) {
		productReviewManager.updateProductReview(prid, pid, review, rating);
		return "OK";
	}
	
	public String deleteProductReview(String id) {
		productReviewManager.deleteProductReview(id);
		return "OK";
	}

}
