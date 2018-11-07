package com.lsmp.mp.order;

import com.lsmp.mp.order.status.OrderStatus;

public class NoOrderYet implements OrderStatus{
	
	Order order;
	
	public NoOrderYet(Order order) {
		this.order = order;
	}

	@Override
	public void noOrderYet() {
		System.out.println("No Order Received yet");
	}

	@Override
	public void updateOrderInProcess(String status) {
		System.out.println("No Order Received yet" + status);
	}

	@Override
	public void updateOrderComplete(String status) {
		System.out.println("No Order Received yet" + status);		
	}

	@Override
	public void updateOrderCancel(String status) {
		System.out.println("No Order Received yet" + status);		
	}

}
