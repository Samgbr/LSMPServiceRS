package com.lsmp.mp.order.service;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.order.service.representation.OrderRepresentation;
import com.lsmp.mp.order.service.representation.OrderRequest;
import com.lsmp.mp.order.service.representation.PaymentRepresentation;
import com.lsmp.mp.order.service.representation.PaymentRequest;

@WebService
public interface OrderService {
	
	//Order representation and request methods goes here
	//public Set<OrderRepresentation> getOrders();
	public OrderRepresentation getOrder(String id);
	public Set<OrderRepresentation> getAllOrders(String id);
	public OrderRepresentation createOrder(OrderRequest orderRequest);
	public PaymentRepresentation createPayment(PaymentRequest paymentRequest);
	public Response updateOrder(OrderRequest orderRequest);
    public Response deleteOrder(String id);
}
