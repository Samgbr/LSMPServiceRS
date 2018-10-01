package com.lsmp.mp.order;

import java.util.Set;

import com.lsmp.dal.order.OrderDAO;
import com.lsmp.dal.order.OrderDetailDAO;

public class OrderManager {
	
	private static OrderDAO oDAO = new OrderDAO();
	private static OrderDetailDAO odDAO = new OrderDetailDAO();
	
	public Order getOrderWithDetail(String id) {
		return oDAO.getOrderWithDetail(id);
	}
	
	public Order addOrder(String oid, String profileID, String orderDate, String shipAddressID, Set<OrderDetail> orderDetails) {
		
		Order order = oDAO.addOrder(oid, profileID, orderDate, shipAddressID, orderDetails);
		
		return order;
	}

	public void updateOrder(String id, String profileID, String orderDate, String shipAddressID, Set<OrderDetail> orderDetails) {
		oDAO.updateOrder(id, profileID, orderDate, shipAddressID);
	}

	public void deleteOrder(String id) {
		oDAO.deleteOrder(id);
	}
	
	//-------------------------------------------
	public OrderDetail getOrderDetail(String id) {
		return odDAO.getOrderDetail(id);
	}
	
	public Set<OrderDetail> getAllOrderDetailsByProfileID(String pid) {
		return odDAO.getAllOrderDetailsByProfileID(pid);
	}
	
	public Set<OrderDetail> getAllOrderDetailsByOrderID(String id) {
		return odDAO.getAllOrderDetailsByOrderID(id);
	}
	
	public OrderDetail addOrderDetail(String odid, String orderID, String productID, double orderedQuantity) {
		return odDAO.addOrderDetail(odid, orderID, productID, orderedQuantity);
	}
	
	public void addOrderDetails(Set<OrderDetail> orderDetails) {
		odDAO.addOrderDetails(orderDetails);
	}
	
	public void updateOrderDetail(String id, String orderID, String productID, double orderedQuantity) {
		odDAO.updateOrderDetail(id, orderID, productID, orderedQuantity);
	}
	
	public void deleteOrderDetail(String id) {
		odDAO.deleteOrderDetail(id);
	}
	
}
