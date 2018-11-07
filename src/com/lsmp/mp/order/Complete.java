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
	public void updateOrderInProcess(String status) {
		System.out.println("Order process already completed" + status);
	}
	@Override
	public void updateOrderComplete(String status) {
		if(status.equalsIgnoreCase("Y")) {
			order.setComplete(this);
			isDelivered = 1;
			orderManager.updateOrderComplete(order.getOrderID(), isDelivered, "");
		}
	}
	@Override
	public void updateOrderCancel(String status) {
		System.out.println("Order not cancelled" + status);		
	}
	@Override
	public void noOrderYet() {
		System.out.println("Order already Initiated");
		isDelivered = 0;
	}
	
}
