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
import com.lsmp.mp.order.service.workflow.OrderActivity;

@Path("/orderservice/")
public class OrderResource implements OrderService{

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/orders")
	public Set<OrderRepresentation> getOrders() {
		System.out.println("GET METHOD Request for all Orders .............");
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getAllOrders();
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{oderId}")
	public OrderRepresentation getOrder(@PathParam("oderId") String id) {
		System.out.println("GET METHOD Request from Client with Order Request String ............." + id);
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getOrder(id);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/order")
	public OrderRepresentation createOrder(OrderRequest orderRequest) {
		System.out.println("POST METHOD Order Request from Client with ............." );		
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.createOrder(orderRequest.getOrderID(), orderRequest.getProfileID(), orderRequest.getOrderDate(), orderRequest.getShipAddressID());
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/order")
	public Response updateOrder(OrderRequest orderRequest) {
		System.out.println("PUT METHOD Order Request from Client with ............." );		
		OrderActivity orderActivity = new OrderActivity();
		String res = orderActivity.updateOrder(orderRequest.getOrderID(), orderRequest.getProfileID(), orderRequest.getOrderDate(), orderRequest.getShipAddressID());
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

}
