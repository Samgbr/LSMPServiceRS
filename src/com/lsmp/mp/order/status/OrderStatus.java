package com.lsmp.mp.order.status;


public interface OrderStatus {
	
	public void noOrderYet();
	public void updateOrderInProcess(String status);
	public void updateOrderComplete(String status);
	public void updateOrderCancel(String status);
}
