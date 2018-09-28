package com.lsmp.mp.order;

import java.util.Set;

import com.lsmp.mp.product.Product;

/**
 * This is an order model class
 * @author samzi
 *
 */

public class Order {

	//Instances
	private String orderNumber;
	private double quantity;
	private double unitprice;
	private Set<Product> products;
		
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}
	
	
}
