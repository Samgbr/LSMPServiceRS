package com.lsmp.mp.product.review;


import java.util.Set;

import com.lsmp.dal.product.review.ProductReviewDAO;

/**
 * This class is responsible for  managing product review 
 * @author samzi
 *
 */

public class ProductReviewManager {
	
private static ProductReviewDAO prDAO = new ProductReviewDAO();

	public Set<ProductReview> getAllProductReviews(String id){
		return prDAO.getAllProductReviews(id);
	}
	public ProductReview getProductReviewByProfileIDandProductID(String id, String pid) {
		return prDAO.getProductReviewByProfileIDandProductID(id,pid);
	}
	
	public ProductReview getProductReviewByProductID(String id) {
		return prDAO.getProductReviewByProductID(id);
	}
	
	public ProductReview addProductReview(String pid, String prid, String review,double rating) {
		
		ProductReview productReview = prDAO.addProductReview(pid, prid, review, rating);
		
		return productReview;
	}

	public void updateProductReview(String id, String pid, String review,double rating) {
		prDAO.updateProductReview(id, pid, review, rating);
	}

	public void deleteProductReview(String id) {
		prDAO.deleteProductReview(id);
	}
	
	

}