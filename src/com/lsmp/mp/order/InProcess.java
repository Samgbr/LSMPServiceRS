package com.lsmp.mp.order;

import com.lsmp.mp.order.status.OrderStatus;

/**
 * This is a process order model class
 * @author samzi
 *
 */
public class InProcess implements OrderStatus{
	
	Order order;
	OrderManager orderManger = new OrderManager();
	
	public InProcess(Order order) {
		this.order = order;
	}

	private int isPicked;
	private int isPacked;
	private int deliveredToPickUpLocation;
	
	public int getDeliveredToPickUpLocation() {
		return deliveredToPickUpLocation;
	}
	public void setDeliveredToPickUpLocation(int deliveredToPickUpLocation) {
		this.deliveredToPickUpLocation = deliveredToPickUpLocation;
	}
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
	
	@Override
	public void updateOrderInProcess(boolean isOrderStarted) {
		order.setInProcess(this);
		isPicked=1;
		isPacked=1;
		deliveredToPickUpLocation=1;
		orderManger.updateOrderInProcess(order.getOrderID(), isPicked, isPacked, deliveredToPickUpLocation);
	}
	@Override
	public void updateOrderComplete(boolean isOrderProcessed) {
		System.out.println("Still Order InProcess");
	}
	
	@Override
	public void updateOrderCancel(boolean refundRequested) {
		System.out.println("Still Order InProcess");
	}
	@Override
	public void noOrderYet(boolean nothing) {
		System.out.println("Order already Initiated");
		isPicked=0;
		isPacked=0;	
		deliveredToPickUpLocation=0;
	}
	
}
