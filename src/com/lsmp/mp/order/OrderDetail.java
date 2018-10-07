package com.lsmp.mp.order;

public class OrderDetail {

	private String orderDetailID;
	private String orderID;
	private String bookProductID;
	private String smartphoneProductID;
	private double orderedQuantity;
	
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
	public String getOrderDetailID() {
		return orderDetailID;
	}
	public void setOrderDetailID(String orderDetailID) {
		this.orderDetailID = orderDetailID;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
	public double getOrderedQuantity() {
		return orderedQuantity;
	}
	public void setOrderedQuantity(double orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}
	
	
}
