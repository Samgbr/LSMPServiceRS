package com.lsmp.mp.order.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class SmartphoneOrderDetailRequest {

	private String orderDetailID;
	private String orderID;
	private String smartphoneProductID;
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
	public String getSmartphoneProductID() {
		return smartphoneProductID;
	}
	public void setSmartphoneProductID(String smartphoneProductID) {
		this.smartphoneProductID = smartphoneProductID;
	}
	public double getOrderedQuantity() {
		return orderedQuantity;
	}
	public void setOrderedQuantity(double orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}
	
}
