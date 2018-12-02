package com.lsmp.mp.order.service;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.lsmp.mp.order.service.representation.OrderRepresentation;
import com.lsmp.mp.order.service.representation.OrderRequest;
import com.lsmp.mp.order.service.representation.PaymentRepresentation;
import com.lsmp.mp.order.service.representation.PaymentRequest;
import com.lsmp.mp.order.service.workflow.OrderActivity;

@Path("/orderservice/")
public class OrderResource implements OrderService{

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{oderId}")
	public OrderRepresentation getOrder(@PathParam("oderId") String id) {
		System.out.println("GET METHOD Request from Client with Order Request String ............." + id);
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getOrder(id);
	}

	@POST
	@Produces({"application/json"})
	@Consumes({"application/json"})
	@Path("/order")
	public OrderRepresentation createOrder(OrderRequest orderRequest) {
		System.out.println("POST METHOD Order Request from Client with ............." );		
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.createOrder(orderRequest.getProfileID(), orderRequest.getOrderDate(), orderRequest.getShipAddressID(),orderRequest.getOrderDetails());
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/order")
	public Response updateOrder(OrderRequest orderRequest) {
		System.out.println("PUT METHOD Order Request from Client with ............." );		
		OrderActivity orderActivity = new OrderActivity();
		String res = orderActivity.updateOrder(orderRequest.getOrderID(), orderRequest.getProfileID(), orderRequest.getOrderDate(), orderRequest.getShipAddressID(),orderRequest.getOrderDetails());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/order/{oderId}")
	public Response deleteOrder(@PathParam("oderId") String id) {
		System.out.println("Delete METHOD Request from Client with Order Request String ............." + id);
		OrderActivity orderActivity = new OrderActivity();
		String res = orderActivity.deleteOrder(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@PUT
	@Produces({"application/json"})
	@Consumes({"application/json"})
	@Path("/payment")
	public PaymentRepresentation createPayment(PaymentRequest paymentRequest) {
		System.out.println("POST METHOD Payment Request from Client with ............." );		
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.createPayment(paymentRequest.getOrderID(), paymentRequest.getAmount(), paymentRequest.getBillID());
	}

	@GET
	@Produces({"application/json"})
	@Path("/orders/{profileID}")
	public Set<OrderRepresentation> getAllOrders(@PathParam("profileID") String id) {
		System.out.println("GET METHOD Request from Client with Orders Request String ............." + id);
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getAllOrders(id);
	}

}
