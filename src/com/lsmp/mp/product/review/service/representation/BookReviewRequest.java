package com.lsmp.mp.product.review.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class BookReviewRequest {
	private String productReviewID;
	private String bookProductID;
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
