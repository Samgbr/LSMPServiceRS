package com.lsmp.mp.order.service.workflow;

import com.lsmp.mp.order.OrderManager;

public class OrderInProcessActivity {

	private static OrderManager orderManager = new OrderManager();
	
	//Process isPicked, isPacked and deliveredToPickUpLocation are boolean values and stored in mysql DB as 0 and 1 (False and True)
	public String updateOrderInProcess(String oid, int isPicked, int isPacked, int deliveredToPickUpLocation) {
		orderManager.updateOrderInProcess(oid, isPicked, isPacked, deliveredToPickUpLocation);
		return "OK";
	}
	
}
