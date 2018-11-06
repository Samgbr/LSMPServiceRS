package com.lsmp.mp.order;

import java.util.Set;

import com.lsmp.dal.order.OrderDAO;
import com.lsmp.dal.order.OrderDetailDAO;

public class OrderManager {
	
	private static OrderDAO oDAO = new OrderDAO();
	private static OrderDetailDAO odDAO = new OrderDetailDAO();
	InProcess processing = new InProcess();
	Complete complete = new Complete();
	Cancel cancel = new Cancel();
	
	public Order getOrderWithDetail(String id) {
		return oDAO.getOrderWithDetail(id);
	}
	
	public Order getOrder(String id) {
		return oDAO.getOrder(id);
	}
	
	public Set<Order> getAllOrders() {
		return oDAO.getAllOrders();
	}
	
	public Order addOrder(String oid, String profileID, String orderDate, String shipAddressID, Set<OrderDetail> orderDetails) {
		
		Order order = oDAO.addOrder(oid, profileID, orderDate, shipAddressID, orderDetails);
		
		return order;
	}
	/*
	public Order addOrder(String oid, String profileID, String orderDate, String shipAddressID) {
		
		Order order = oDAO.addOrder(oid, profileID, orderDate, shipAddressID);
		
		return order;
	} 
	
	public Order addSmartphoneOrder(String oid, String profileID, String orderDate, String shipAddressID, Set<OrderDetail> orderDetails) {
		
		Order order = oDAO.addSmartphoneOrder(oid, profileID, orderDate, shipAddressID, orderDetails);
		
		return order;
	}  */

	public void updateOrder(String id, String profileID, String orderDate, String shipAddressID,Set<OrderDetail> details) {
		oDAO.updateOrder(id, profileID, orderDate, shipAddressID,details);
	}

	public void deleteOrder(String id) {
		oDAO.deleteOrder(id);
	}
	
	//-------------------------------------------
	public OrderDetail getOrderDetail(String id) {
		return odDAO.getOrderDetail(id);
	}
	/*
	public Set<OrderDetail> getAllOrderDetailsByProfileID(String pid) {
		return odDAO.getAllOrderDetailsByProfileID(pid);
	} */
	
	public Set<OrderDetail> getAllOrderDetailsByOrderID(String id) {
		return odDAO.getAllOrderDetailsByOrderID(id);
	}
	/*
	public Set<OrderDetail> getAllSmartphoneOrderDetailsByOrderID(String id) {
		return odDAO.getAllSmartphoneOrderDetailsByOrderID(id);
	}
	public OrderDetail getBookOrderDetail(String id) {
		return odDAO.getBookOrderDetail(id);
	} */
	public Set<OrderDetail> getAllOrderDetails() {
		return odDAO.getAllOrderDetails();
	}
	/*
	public Set<OrderDetail> getAllSmartphoneOrderDetails() {
		return odDAO.getAllSmartphoneOrderDetails();
	}
	public OrderDetail getSmartphoneOrderDetail(String id) {
		return odDAO.getSmartphoneOrderDetail(id);
	} */
	public OrderDetail addOrderDetail(String odid, String orderID, String productID, double orderedQuantity) {
		return odDAO.addOrderDetail(odid, orderID, productID, orderedQuantity);
	}
	/*
	public OrderDetail addSmartphoneOrderDetail(String odid, String orderID, String productID, double orderedQuantity) {
		return odDAO.addSmartphoneOrderDetail(odid, orderID, productID, orderedQuantity);
	} */
	
	public void addOrderDetails(Set<OrderDetail> orderDetails) {
		odDAO.addOrderDetails(orderDetails);
	}
	/*
	public void addSmartphoneOrderDetails(Set<OrderDetail> orderDetails) {
		odDAO.addSmartphoneOrderDetails(orderDetails);
	} */
	
	public void updateOrderDetail(String id, String orderID, String productID, double orderedQuantity) {
		odDAO.updateOrderDetail(id, orderID, productID, orderedQuantity);
	}
	/*
	public void updateSmartphoneOrderDetail(String id, String orderID, String productID, double orderedQuantity) {
		odDAO.updateSmartphoneOrderDetail(id, orderID, productID, orderedQuantity);
	}  */
	
	public void updateOrderInProcess(String id, int isPicked, int isPacked,int deliveredToPickUpLocation) {
		oDAO.updateOrderInProcess(id, isPicked, isPacked, deliveredToPickUpLocation);
	}
	public void updateOrderComplete(String id, int isDelivered, String pickUpLocation) {
		oDAO.updateOrderComplete(id, isDelivered, pickUpLocation);
	}
	public void updateOrderCancel(String id, int refund) {
		oDAO.updateOrderCancel(id, refund);
	}
	public void deleteOrderDetail(String id) {
		odDAO.deleteOrderDetail(id);
	}
	public void deleteOrderDetailWithOrderID(String id) {
		odDAO.deleteOrderDetailWithOrderID(id);
	}
	
	public OrderDetail createOrderDetail(String orderDetailID, String orderID, String productID, double orderedQuantity) {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderDetailID(orderDetailID);
		orderDetail.setProductID(productID);
		orderDetail.setOrderID(orderID);
		orderDetail.setOrderedQuantity(orderedQuantity);
		return orderDetail;
	}
	/*
	public OrderDetail createSmartphoneOrderDetail(String orderDetailID, String orderID, String productID, double orderedQuantity) {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderDetailID(orderDetailID);
		orderDetail.setSmartphoneProductID(productID);
		orderDetail.setOrderID(orderID);
		orderDetail.setOrderedQuantity(orderedQuantity);
		return orderDetail;
	} */
	
	public void processingOrder(Order order) {
		order.setStatus(processing);
	}
	
	/**
	 * This method set order status to complete
	 * @param order
	 */
	public void completeOrder(Order order) {
		order.setStatus(complete);
	}
	
	// this method is to cancel order
	public void cancelOrder(Order order) {
		order.setStatus(cancel);
		initializeOrderProcess();
	}
	
	private void initializeOrderProcess() {
		processing = new InProcess();
		complete = new Complete();
		cancel = new Cancel();
	}

	public void packagePicked() {
		processing.setPicked(1);
	}
	
	public void packagePacked() {
		processing.setPacked(1);
	}
	
	public void orderRefund() {
		cancel.setRefund(1);
	}
	public void deliverdToPickupLocation() {
		processing.setDeliverdToPickupLocation(1);
	}
	
	public void orderPickupLocation(String location) {
		complete.setPickupLocation(location);
	}
	
	public void orderDelivered() {
		complete.setDelivered(1);
	}
}
