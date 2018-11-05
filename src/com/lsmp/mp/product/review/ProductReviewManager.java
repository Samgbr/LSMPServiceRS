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

	public Set<ProductReview> getAllProductReviews(){
		return prDAO.getAllProductReviews();
	}
	public ProductReview getProductReviewByProfileIDandProductID(String id, String pid) {
		return prDAO.getProductReviewByProfileIDandProductID(id,pid);
	}
	
	public ProductReview addProductReview(String id, String pid, String prid, String review,double rating) {
		
		ProductReview productReview = prDAO.addProductReview(id, pid, prid, review, rating);
		
		return productReview;
	}

	public void updateProductReview(String id, String pid, String review,double rating) {
		prDAO.updateProductReview(id, pid, review, rating);
	}

	public void deleteProductReview(String id) {
		prDAO.deleteProductReview(id);
	}
	
	

}