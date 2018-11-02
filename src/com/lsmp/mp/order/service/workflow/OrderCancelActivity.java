package com.lsmp.mp.order.service.workflow;

import com.lsmp.mp.order.OrderManager;

public class OrderCancelActivity {

	private static OrderManager orderManager = new OrderManager();
	
	public String updateOrderCancel(String oid, int refund) {
		orderManager.updateOrderCancel(oid, refund);
		return "OK";
	}
}
