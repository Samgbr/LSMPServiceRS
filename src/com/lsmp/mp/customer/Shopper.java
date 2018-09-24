package com.lsmp.mp.customer;

import java.util.List;
import java.util.Set;

import com.lsmp.mp.order.Order;
import com.lsmp.mp.product.ProductReview;

/**
 * This Shopper model class
 * @author samzi
 *
 */
public class Shopper extends Customer {

	//Instances
	private String shopperType;
	private List<Order> orders;
	private Set<ProductReview> reviews;
		
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public String getShopperType() {
		return shopperType;
	}

	public void setShopperType(String shopperType) {
		this.shopperType = shopperType;
	}
	
	
}
