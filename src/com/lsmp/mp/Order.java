package com.lsmp.mp;

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
