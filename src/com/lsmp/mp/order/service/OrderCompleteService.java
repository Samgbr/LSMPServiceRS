package com.lsmp.mp.order.service;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.order.service.representation.OrderCompleteRequest;

@WebService
public interface OrderCompleteService {

	public Response updateOrderComplete(OrderCompleteRequest orderCompleteRequest);
}
