package com.lsmp.mp.customer;

import java.util.Set;

import com.lsmp.mp.order.Order;
import com.lsmp.mp.product.review.ProductReview;

/**
 * This Shopper model class
 * @author samzi
 *
 */
public class Shopper extends Customer {

	//Instances
	private Set<Order> orders;
	private Set<ProductReview> reviews;

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
