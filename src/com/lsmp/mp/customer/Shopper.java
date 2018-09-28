package com.lsmp.mp.customer;

import java.util.Set;

import com.lsmp.mp.order.Order;
import com.lsmp.mp.product.review.ProductReview;

/**
 * This Shopper model class
 * @author samzi
 *
 */
public class Shopper extends Profile {

	//Instances
	private String shopperType;
	private Set<Order> orders;
	private Set<ProductReview> reviews;

	public String getShopperType() {
		return shopperType;
	}

	public void setShopperType(String shopperType) {
		this.shopperType = shopperType;
	}

	public Set<ProductReview> getReviews() {
		return reviews;
	}

	public void setReviews(Set<ProductReview> reviews) {
		this.reviews = reviews;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	
	
}
