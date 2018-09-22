package com.lsmp.mp;

/**
 * This is a process order model class
 * @author samzi
 *
 */
public class InProcess extends Order {

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
	
}
