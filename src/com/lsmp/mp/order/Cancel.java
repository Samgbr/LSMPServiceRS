package com.lsmp.mp.order;

import com.lsmp.mp.order.status.OrderStatus;

/**
 * This is a cancel order model class
 * @author samzi
 *
 */
public class Cancel implements OrderStatus {

	Order order;
	OrderManager orderManager = new OrderManager();
	
	public Cancel(Order order) {
		this.order = order;
	}
	
	private int refund;

	public int isRefund() {
		return refund;
	}

	public void setRefund(int refund) {
		this.refund = refund;
	}

	@Override
	public void updateOrderInProcess(boolean isOrderStarted) {
		System.out.println("Order not processed");
	}

	@Override
	public void updateOrderComplete(boolean isOrderProcessed) {
		System.out.println("Order not completed");	
	}

	@Override
	public void updateOrderCancel(boolean refundRequested) {
		order.setCancel(this);
		refund = 1;
		orderManager.updateOrderCancel(order.getOrderID(), refund);	
	}
	@Override
	public void noOrderYet(boolean nothing) {
		System.out.println("Order already Initiated");
		refund = 0;
	}
	
}
