package com.lsmp.mp.order.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.mp.order.Order;
import com.lsmp.mp.order.OrderManager;
import com.lsmp.mp.order.service.representation.OrderRepresentation;

public class OrderActivity {

private static OrderManager orderManager = new OrderManager();
	
	public OrderRepresentation getOrder(String id) {
		
		Order order = orderManager.getOrder(id);
		
		OrderRepresentation orderRepresentation = new OrderRepresentation();
		orderRepresentation.setOrderID(order.getOrderID());
		orderRepresentation.setOrderDate(order.getOrderDate());
		orderRepresentation.setProfileID(order.getProfileID());
		orderRepresentation.setShipAddressID(order.getShipAddressID());
		
		return orderRepresentation;
	}

	public Set<OrderRepresentation> getAllOrders() {
		
		Set<Order> orders = new HashSet<Order>();
		Set<OrderRepresentation> orderRepresentations = new HashSet<OrderRepresentation>();
		
		orders = orderManager.getAllOrders();
		
		Iterator<Order> it = orders.iterator();
		while(it.hasNext()) {
          Order order = (Order)it.next();
          OrderRepresentation orderRepresentation = new OrderRepresentation();
  		  orderRepresentation.setOrderID(order.getOrderID());
  		  orderRepresentation.setOrderDate(order.getOrderDate());
  		  orderRepresentation.setProfileID(order.getProfileID());
  		  orderRepresentation.setShipAddressID(order.getShipAddressID());
          
          //now add this representation in the list
  		orderRepresentations.add(orderRepresentation);
        }
		return orderRepresentations;
	}

	public OrderRepresentation createOrder(String oid, String profileID, String orderDate, String shipAddressID) {
		
		Order order = orderManager.addOrder(oid, profileID, orderDate, shipAddressID);
		
		OrderRepresentation orderRepresentation = new OrderRepresentation();
		orderRepresentation.setOrderID(order.getOrderID());
		orderRepresentation.setOrderDate(order.getOrderDate());
		orderRepresentation.setProfileID(order.getProfileID());
		orderRepresentation.setShipAddressID(order.getShipAddressID());
        
		return orderRepresentation;
	}

	public String updateOrder(String oid, String profileID, String orderDate, String shipAddressID) {
		orderManager.updateOrder(oid, profileID, orderDate, shipAddressID);
		return "OK";
	}

	public String deleteOrder(String id) {
		orderManager.deleteOrder(id);
		return "OK";
	}

}
