package com.lsmp.mp.order.service;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.order.service.representation.OrderCancelRequest;

@WebService
public interface OrderCancelService {

	public Response updateOrderCancel(OrderCancelRequest orderCancelRequest);
}
