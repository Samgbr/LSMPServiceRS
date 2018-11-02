package com.lsmp.mp.order;

import com.lsmp.mp.order.status.OrderStatus;

/**
 * This is a process order model class
 * @author samzi
 *
 */
public class InProcess extends Order implements OrderStatus{

	private int isPicked;
	private int isPacked;
	private int deliverdToPickupLocation;
	
	public int isPicked() {
		return isPicked;
	}
	public void setPicked(int isPicked) {
		this.isPicked = isPicked;
	}
	public int isPacked() {
		return isPacked;
	}
	public void setPacked(int isPacked) {
		this.isPacked = isPacked;
	}
	public int isDeliverdToPickupLocation() {
		return deliverdToPickupLocation;
	}
	public void setDeliverdToPickupLocation(int deliverdToPickupLocation) {
		this.deliverdToPickupLocation = deliverdToPickupLocation;
	}
	
	
	@Override
	public void status(Order order) {
		// In process status goes here
		System.out.println("Processing Order");
		order.setStatus(this);
	}
	
}
