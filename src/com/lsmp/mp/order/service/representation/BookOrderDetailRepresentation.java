package com.lsmp.mp.order.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "bookOrderDetailRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class BookOrderDetailRepresentation {

	private String orderDetailID;
	private String orderID;
	private String bookProductID;
	private double orderedQuantity;
	
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
	public String getBookProductID() {
		return bookProductID;
	}
	public void setBookProductID(String bookProductID) {
		this.bookProductID = bookProductID;
	}
	public double getOrderedQuantity() {
		return orderedQuantity;
	}
	public void setOrderedQuantity(double orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}
	
}
