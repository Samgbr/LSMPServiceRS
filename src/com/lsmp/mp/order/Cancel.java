package com.lsmp.mp.order;

/**
 * This is a cancel order model class
 * @author samzi
 *
 */
public class Cancel extends Order {

	private boolean refund;

	public boolean isRefund() {
		return refund;
	}

	public void setRefund(boolean refund) {
		this.refund = refund;
	}
	
}
