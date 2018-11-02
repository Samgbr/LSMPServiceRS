package com.lsmp.mp.order.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.lsmp.mp.order.service.representation.OrderCancelRequest;
import com.lsmp.mp.order.service.workflow.OrderCancelActivity;

@Path("/ordercancelservice/")
public class OrderCancelResource implements OrderCancelService{

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/ordercancel")
	public Response updateOrderCancel(OrderCancelRequest orderCancelRequest) {
		System.out.println("PUT METHOD Order Cancel Request from Client with ............." );		
		OrderCancelActivity orderCancelActivity = new OrderCancelActivity();
		String res = orderCancelActivity.updateOrderCancel(orderCancelRequest.getOrderID(), orderCancelRequest.getRefund());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

}
