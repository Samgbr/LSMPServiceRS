package com.lsmp.mp.order;

import java.util.Set;

import com.lsmp.mp.order.status.OrderStatus;

/**
 * This is an order model class
 * @author samzi
 *
 */

public class Order {

	//Instances
	private String orderID;
	private String profileID;
	private String orderDate;
	private String shipAddressID;
	private Set<OrderDetail> orderDetails;
	
	private OrderStatus status;
	
	public Order() {
		status=null;
	}
	
	
	public String getShipAddressID() {
		return shipAddressID;
	}


	public void setShipAddressID(String shipAddressID) {
		this.shipAddressID = shipAddressID;
	}


	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}


	public String getOrderID() {
		return orderID;
	}


	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}


	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}	
	
	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public String getProfileID() {
		return profileID;
	}
	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}
	
}
