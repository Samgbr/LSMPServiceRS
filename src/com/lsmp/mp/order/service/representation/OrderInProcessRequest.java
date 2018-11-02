package com.lsmp.mp.order.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderInProcessRequest {

	private String orderID;
	private int isPicked;
	private int isPacked;
	private int deliverdToPickupLocation;
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public int getIsPicked() {
		return isPicked;
	}
	public void setIsPicked(int isPicked) {
		this.isPicked = isPicked;
	}
	public int getIsPacked() {
		return isPacked;
	}
	public void setIsPacked(int isPacked) {
		this.isPacked = isPacked;
	}
	public int getDeliverdToPickupLocation() {
		return deliverdToPickupLocation;
	}
	public void setDeliverdToPickupLocation(int deliverdToPickupLocation) {
		this.deliverdToPickupLocation = deliverdToPickupLocation;
	}
	
	
	
}
