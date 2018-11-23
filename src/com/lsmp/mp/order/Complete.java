package com.lsmp.mp.order;

import com.lsmp.mp.order.status.OrderStatus;

/**
 * This is an order complete model class
 * @author samzi
 *
 */

public class Complete implements OrderStatus {
	
	Order order;
	OrderManager orderManager = new OrderManager();
	
	public Complete(Order order) {
		this.order = order;
	}

	private String pickupLocation;
	private int isDelivered;
	
	public String getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public int isDelivered() {
		return isDelivered;
	}
	public void setDelivered(int isDelivered) {
		this.isDelivered = isDelivered;
	}
	
	@Override
	public void updateOrderInProcess(boolean isOrderStarted) {
		System.out.println("Order process already completed");
	}
	@Override
	public void updateOrderComplete(boolean isOrderProcessed) {
		order.setComplete(this);
		isDelivered = 1;
		orderManager.updateOrderComplete(order.getOrderID(), isDelivered, "");
	}
	@Override
	public void updateOrderCancel(boolean refundRequested) {
		System.out.println("Order not cancelled");		
	}
	@Override
	public void noOrderYet(boolean nothing) {
		System.out.println("Order already Initiated");
		isDelivered = 0;
	}
	
}
