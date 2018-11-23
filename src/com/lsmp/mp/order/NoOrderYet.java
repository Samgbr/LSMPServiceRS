package com.lsmp.mp.order;

import com.lsmp.mp.order.status.OrderStatus;

public class NoOrderYet implements OrderStatus{
	
	Order order;
	
	public NoOrderYet(Order order) {
		this.order = order;
	}

	@Override
	public void noOrderYet(boolean nothing) {
		System.out.println("No Order Received yet");
	}

	@Override
	public void updateOrderInProcess(boolean isOrderStarted) {
		System.out.println("No Order Received yet");
	}

	@Override
	public void updateOrderComplete(boolean isOrderProcessed) {
		System.out.println("No Order Received yet");		
	}

	@Override
	public void updateOrderCancel(boolean refundRequested) {
		System.out.println("No Order Received yet");		
	}


}
