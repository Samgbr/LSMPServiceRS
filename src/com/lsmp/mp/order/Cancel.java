package com.lsmp.mp.order;

import com.lsmp.mp.order.status.OrderStatus;

/**
 * This is a cancel order model class
 * @author samzi
 *
 */
public class Cancel extends Order implements OrderStatus {

	private int refund;

	public int isRefund() {
		return refund;
	}

	public void setRefund(int refund) {
		this.refund = refund;
	}

	@Override
	public void status(Order order) {
		//Cancel status goes here
		refund = 1;
		order.setStatus(this);	
	}
	
}
