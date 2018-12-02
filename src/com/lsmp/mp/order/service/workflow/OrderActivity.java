package com.lsmp.mp.order.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.mp.link.Link;
import com.lsmp.mp.order.Order;
import com.lsmp.mp.order.OrderDetail;
import com.lsmp.mp.order.OrderManager;
import com.lsmp.mp.order.service.representation.OrderRepresentation;
import com.lsmp.mp.order.service.representation.PaymentRepresentation;

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
	
	
	public Set<OrderRepresentation> getAllOrders(String id) {
		Set<Order> orders = new HashSet<>();
		Set<OrderRepresentation> orderRepresentations = new HashSet<OrderRepresentation>();
		
		orders = orderManager.getAllOrders(id);
		
		Iterator<Order> it = orders.iterator();
		while(it.hasNext()) {
          
			Order order = (Order)it.next();
			OrderRepresentation orderRepresentation = new OrderRepresentation();
			orderRepresentation.setOrderID(order.getOrderID());
			orderRepresentation.setOrderDate(order.getOrderDate());
			orderRepresentation.setProfileID(order.getProfileID());
			orderRepresentation.setShipAddressID(order.getShipAddressID());
			orderRepresentation.setOrderDetails(order.getOrderDetails());
			
			orderRepresentations.add(orderRepresentation);
		}
		
		return orderRepresentations;
	}

	public OrderRepresentation createOrder(String profileID, String orderDate, String shipAddressID,Set<OrderDetail> orderDetails) {
		
		Order order = orderManager.addOrder(profileID, orderDate, shipAddressID, orderDetails);
		
		OrderRepresentation orderRepresentation = new OrderRepresentation();
		orderRepresentation.setOrderID(order.getOrderID());
		orderRepresentation.setOrderDate(order.getOrderDate());
		orderRepresentation.setProfileID(order.getProfileID());
		orderRepresentation.setShipAddressID(order.getShipAddressID());
		orderRepresentation.setOrderDetails(order.getOrderDetails());
		orderRepresentation.setOrderDetails(order.getOrderDetails());
        
		setLinks(orderRepresentation);
		
		return orderRepresentation;
	}

	private void setLinks(OrderRepresentation orderRepresentation) {
		Link payment = new Link("payment", 
				"http://localhost:8082/Order/orderservice/payment" ,"application/xml");
					
		orderRepresentation.setLinks(payment);
	}

	public PaymentRepresentation createPayment(String oid, double amount, String billID) {
		
		Order order = orderManager.addPayment(oid, amount, billID);
		
		PaymentRepresentation paymentRepresentation = new PaymentRepresentation();
		paymentRepresentation.setOrderID(order.getOrderID());
		paymentRepresentation.setAmount(order.getAmount());
		paymentRepresentation.setBillID(order.getBillID());
        
		return paymentRepresentation;
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
