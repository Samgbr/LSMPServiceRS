package com.lsmp.mp.product.review;

/**
 * This class is a product review model class
 * @author samzi
 *
 */

public class ProductReview {
	
	private String productReviewID;
	private String bookProductID;
	private String smartphoneProductID;
	private String profileID;
	private String review;
	private double rating;
	
	public String getProductReviewID() {
		return productReviewID;
	}
	public void setProductReviewID(String productReviewID) {
		this.productReviewID = productReviewID;
	}
	public String getBookProductID() {
		return bookProductID;
	}
	public void setBookProductID(String bookProductID) {
		this.bookProductID = bookProductID;
	}
	public String getSmartphoneProductID() {
		return smartphoneProductID;
	}
	public void setSmartphoneProductID(String smartphoneProductID) {
		this.smartphoneProductID = smartphoneProductID;
	}
	public String getProfileID() {
		return profileID;
	}
	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	

}
