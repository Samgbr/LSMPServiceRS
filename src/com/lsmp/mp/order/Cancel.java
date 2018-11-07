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
	public void updateOrderInProcess(String status) {
		System.out.println("Order not processed" + status);
	}

	@Override
	public void updateOrderComplete(String status) {
		System.out.println("Order not completed" + status);	
	}

	@Override
	public void updateOrderCancel(String status) {
		if (status.equalsIgnoreCase("Y")) {
			order.setCancel(this);
			refund = 1;
			orderManager.updateOrderCancel(order.getOrderID(), refund);
		}	
	}
	@Override
	public void noOrderYet() {
		System.out.println("Order already Initiated");
		refund = 0;
	}
	
}
