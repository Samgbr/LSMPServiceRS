package com.lsmp.mp.order.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.lsmp.mp.order.service.representation.OrderCompleteRequest;
import com.lsmp.mp.order.service.workflow.OrderCompleteActivity;

@Path("/ordercompleteservice/")
public class OrderCompleteResource implements OrderCompleteService{

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/ordercomplete")
	public Response updateOrderComplete(OrderCompleteRequest orderCompleteRequest) {
		System.out.println("PUT METHOD Order Complete Request from Client with ............." );		
		OrderCompleteActivity orderCompleteActivity = new OrderCompleteActivity();
		String res = orderCompleteActivity.updateOrderComplete(orderCompleteRequest.getOrderID(), orderCompleteRequest.getIsDelivered()
				, orderCompleteRequest.getPickupLocation());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

}
