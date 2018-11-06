package com.lsmp.mp.order.service.workflow;

import java.util.Set;

import com.lsmp.mp.order.Order;
import com.lsmp.mp.order.OrderDetail;
import com.lsmp.mp.order.OrderManager;
import com.lsmp.mp.order.service.representation.OrderRepresentation;

public class OrderActivity {

	private static OrderManager orderManager = new OrderManager();
	
	public OrderRepresentation getOrder(String id) {
		
		Order order = orderManager.getOrderWithDetail(id);
		
		OrderRepresentation orderRepresentation = new OrderRepresentation();
		orderRepresentation.setOrderID(order.getOrderID());
		orderRepresentation.setOrderDate(order.getOrderDate());
		orderRepresentation.setProfileID(order.getProfileID());
		orderRepresentation.setShipAddressID(order.getShipAddressID());
		orderRepresentation.setOrderDetails(order.getOrderDetails());
		
		return orderRepresentation;
	}

	public OrderRepresentation createOrder(String oid, String profileID, String orderDate, String shipAddressID,Set<OrderDetail> orderDetails) {
		
		Order order = orderManager.addOrder(oid, profileID, orderDate, shipAddressID, orderDetails);
		
		OrderRepresentation orderRepresentation = new OrderRepresentation();
		orderRepresentation.setOrderID(order.getOrderID());
		orderRepresentation.setOrderDate(order.getOrderDate());
		orderRepresentation.setProfileID(order.getProfileID());
		orderRepresentation.setShipAddressID(order.getShipAddressID());
		orderRepresentation.setOrderDetails(order.getOrderDetails());
		orderRepresentation.setOrderDetails(order.getOrderDetails());
        
		return orderRepresentation;
	}

	public String updateOrder(String oid, String profileID, String orderDate, String shipAddressID,Set<OrderDetail> details) {
		orderManager.updateOrder(oid, profileID, orderDate, shipAddressID, details);
		return "OK";
	}

	public String deleteOrder(String id) {
		orderManager.deleteOrder(id);
		return "OK";
	}

}
