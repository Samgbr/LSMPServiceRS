package com.lsmp.mp.product.service;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.product.service.representation.SmartphoneRepresentation;
import com.lsmp.mp.product.service.representation.SmartphoneRequest;

@WebService
public interface SmartphoneService {
	
	public SmartphoneRepresentation getSmartphone(String id);
	public Set<SmartphoneRepresentation> getSmartphones();
	public SmartphoneRepresentation createSmartphone(SmartphoneRequest smartphoneRequest);
	public Response updateSmartphone(SmartphoneRequest smartphoneRequest);
    public Response deleteSmartphone(String id);

}
