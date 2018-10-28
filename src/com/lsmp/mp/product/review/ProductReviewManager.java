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

	public Set<ProductReview> getAllBookReviews(){
		return prDAO.getAllBookReviews();
	}
	public ProductReview getBookReviewByProfileIDandProductID(String id, String pid) {
		return prDAO.getBookReviewByProfileIDandProductID(id,pid);
	}
	public ProductReview getSmartphoneReviewByProfileIDandProductID(String id, String pid) {
		return prDAO.getSmartphoneReviewByProfileIDandProductID(id, pid);
	}
	
	public ProductReview addBookReview(String id, String pid, String prid, String review,double rating) {
		
		ProductReview productReview = prDAO.addBookReview(id, pid, prid, review, rating);
		
		return productReview;
	}
	
	public Set<ProductReview> getAllSmartPhoneReviews(){
		return prDAO.getAllSmartPhoneReviews();
	}
	public ProductReview addSmartphoneReview(String id, String pid, String prid, String review,double rating) {
		
		ProductReview productReview = prDAO.addSmartphoneReview(id, pid, prid, review, rating);
		
		return productReview;
	}

	public void updateBookReview(String id, String pid, String review,double rating) {
		prDAO.updateBookReview(id, pid, review, rating);
	}
	
	public void updateSmartphoneReview(String id, String pid, String review,double rating) {
		prDAO.updateSmartphoneReview(id, pid, review, rating);
	}

	public void deleteProductReview(String id) {
		prDAO.deleteProductReview(id);
	}
	
	

}
