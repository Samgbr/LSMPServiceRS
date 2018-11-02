package com.lsmp.mp.order;

import com.lsmp.mp.order.status.OrderStatus;

/**
 * This is an order complete model class
 * @author samzi
 *
 */

public class Complete extends Order implements OrderStatus{

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
	public void status(Order order) {
		// Complete status set here
		isDelivered = 1;
		order.setStatus(this);
	}
	
}
