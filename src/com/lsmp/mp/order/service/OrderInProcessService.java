package com.lsmp.mp.order.service;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.order.service.representation.OrderInProcessRequest;

@WebService
public interface OrderInProcessService {

	public Response updateOrderInProcess(OrderInProcessRequest orderInProcessRequest);
}
