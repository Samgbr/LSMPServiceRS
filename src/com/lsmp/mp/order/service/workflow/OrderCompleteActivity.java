package com.lsmp.mp.order.service.workflow;

import com.lsmp.mp.order.OrderManager;

public class OrderCompleteActivity {

	private static OrderManager orderManager = new OrderManager();
	
	public String updateOrderComplete(String oid, int isDelivered, String pickUpLocation) {
		orderManager.updateOrderComplete(oid, isDelivered, pickUpLocation);
		return "OK";
	}
	
}
