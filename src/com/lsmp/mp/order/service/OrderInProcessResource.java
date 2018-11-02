package com.lsmp.mp.order.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.lsmp.mp.order.service.representation.OrderInProcessRequest;
import com.lsmp.mp.order.service.workflow.OrderInProcessActivity;

@Path("/orderinprocessservice/")
public class OrderInProcessResource implements OrderInProcessService{

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/orderinprocess")
	public Response updateOrderInProcess(OrderInProcessRequest orderInProcessRequest) {
		System.out.println("PUT METHOD Order InProcess Request from Client with ............." );		
		OrderInProcessActivity orderInProcessActivity = new OrderInProcessActivity();
		String res = orderInProcessActivity.updateOrderInProcess(orderInProcessRequest.getOrderID(), orderInProcessRequest.getIsPicked()
				, orderInProcessRequest.getIsPacked(), orderInProcessRequest.getDeliverdToPickupLocation());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

}
