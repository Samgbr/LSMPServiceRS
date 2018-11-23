package com.lsmp.mp.order.status;


public interface OrderStatus {
	
	public void noOrderYet(boolean nothing);
	public void updateOrderInProcess(boolean isOrderStarted);
	public void updateOrderComplete(boolean isOrderProcessed);
	public void updateOrderCancel(boolean refundRequested);
}
