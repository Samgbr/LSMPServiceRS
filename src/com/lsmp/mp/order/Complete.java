package com.lsmp.mp.order;

import com.lsmp.mp.order.status.OrderStatus;

/**
 * This is an order complete model class
 * @author samzi
 *
 */

public class Complete extends Order implements OrderStatus{

	private String pickupLocation;
	private boolean isDelivered;
	
	public String getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public boolean isDelivered() {
		return isDelivered;
	}
	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}
	
	@Override
	public void status(Order order) {
		// Complete status set here
		isDelivered = true;
		order.setStatus(this);
	}
	
}
