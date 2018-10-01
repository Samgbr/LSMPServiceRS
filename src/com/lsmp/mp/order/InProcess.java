package com.lsmp.mp.order;

import com.lsmp.mp.order.status.OrderStatus;

/**
 * This is a process order model class
 * @author samzi
 *
 */
public class InProcess extends Order implements OrderStatus{

	private boolean isPicked;
	private boolean isPacked;
	private boolean deliverdToPickupLocation;
	
	public boolean isPicked() {
		return isPicked;
	}
	public void setPicked(boolean isPicked) {
		this.isPicked = isPicked;
	}
	public boolean isPacked() {
		return isPacked;
	}
	public void setPacked(boolean isPacked) {
		this.isPacked = isPacked;
	}
	public boolean isDeliverdToPickupLocation() {
		return deliverdToPickupLocation;
	}
	public void setDeliverdToPickupLocation(boolean deliverdToPickupLocation) {
		this.deliverdToPickupLocation = deliverdToPickupLocation;
	}
	
	
	@Override
	public void status(Order order) {
		// In process status goes here
		System.out.println("Processing Order");
		order.setStatus(this);
	}
	
}
