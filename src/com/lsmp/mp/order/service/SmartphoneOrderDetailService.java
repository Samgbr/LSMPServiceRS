package com.lsmp.mp.order.service;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.order.service.representation.SmartphoneOrderDetailRepresentation;
import com.lsmp.mp.order.service.representation.SmartphoneOrderDetailRequest;

@WebService
public interface SmartphoneOrderDetailService {

	
	public Set<SmartphoneOrderDetailRepresentation> getSmartphoneOrderDetails();
	public SmartphoneOrderDetailRepresentation getSmartphoneOrderDetail(String id);
	public SmartphoneOrderDetailRepresentation createSmartphoneOrderDetail(SmartphoneOrderDetailRequest smartphoneOrderDetailRequest);
	public Response updateSmartphoneOrderDetail(SmartphoneOrderDetailRequest smartphoneOrderDetailRequest);
    public Response deleteSmartphoneOrderDetail(String id);
}
