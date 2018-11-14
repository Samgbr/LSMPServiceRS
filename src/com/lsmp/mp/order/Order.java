package com.lsmp.mp.order;

import java.util.Set;

import com.lsmp.mp.order.status.OrderStatus;

/**
 * This is an order model class
 * @author samzi
 *
 */

public class Order {
	
	//Order status
	OrderStatus inProcess;
	OrderStatus complete;
	OrderStatus cancel;
	OrderStatus noOrderYet;
	
	boolean orderStarted;
	
	OrderStatus currentOrderStatus;

	//Instances
	private String orderID;
	private String profileID;
	private String orderDate;
	private String shipAddressID;
	private String billID;
	private double amount;
	private Set<OrderDetail> orderDetails;
	
	public Order() {
		inProcess = new InProcess(this);
		complete = new Complete(this);
		cancel = new Cancel(this);
		noOrderYet= new NoOrderYet(this);
		
		currentOrderStatus = noOrderYet;
		
		if (orderStarted == true) {
			currentOrderStatus = inProcess;
		}
	}
	
	public String getBillID() {
		return billID;
	}

	public void setBillID(String billID) {
		this.billID = billID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isOrderStarted() {
		return orderStarted;
	}

	public void setOrderStarted(boolean orderStarted) {
		this.orderStarted = orderStarted;
	}

	public void noOrderYet() {
		currentOrderStatus.noOrderYet(true);
	}
	
	public void updateOrderInProcess() {
		currentOrderStatus.updateOrderInProcess(false);
	}
	
	public void updateOrderComplete() {
		currentOrderStatus.updateOrderComplete(false);
	}
	
	public void updateOrderCancel() {
		currentOrderStatus.updateOrderCancel(false);
	}
	
	public OrderStatus getInProcess() {
		return inProcess;
	}


	public void setInProcess(OrderStatus inProcess) {
		this.inProcess = inProcess;
	}


	public OrderStatus getComplete() {
		return complete;
	}


	public void setComplete(OrderStatus complete) {
		this.complete = complete;
	}


	public OrderStatus getCancel() {
		return cancel;
	}


	public void setCancel(OrderStatus cancel) {
		this.cancel = cancel;
	}


	public OrderStatus getCurrentOrderStatus() {
		return currentOrderStatus;
	}


	public void setCurrentOrderStatus(OrderStatus currentOrderStatus) {
		this.currentOrderStatus = currentOrderStatus;
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

	public String getProfileID() {
		return profileID;
	}
	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}
	
}
