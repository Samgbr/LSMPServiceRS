package com.lsmp.mp;

import java.util.List;

/**
 * This Shopper model class
 * @author samzi
 *
 */
public class Shopper extends Customer {

	//Instances
	private String shopperType;
	private List<BookReview> bookReviews;
	private List<SmartphoneReview> smartphoneReviews;
	private List<Order> orders;
		
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<SmartphoneReview> getSmartphoneReviews() {
		return smartphoneReviews;
	}

	public void setSmartphoneReviews(List<SmartphoneReview> smartphoneReviews) {
		this.smartphoneReviews = smartphoneReviews;
	}

	public List<BookReview> getBookReviews() {
		return bookReviews;
	}
	
	public void setBookReviews(List<BookReview> bookReviews) {
		this.bookReviews = bookReviews;
	}

	public String getShopperType() {
		return shopperType;
	}

	public void setShopperType(String shopperType) {
		this.shopperType = shopperType;
	}
	
	
}
