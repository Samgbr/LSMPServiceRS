package com.lsmp.mp.product.service;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.product.service.representation.SmartphoneInventoryRepresentation;
import com.lsmp.mp.product.service.representation.SmartphoneInventoryRequest;

@WebService
public interface SmartphoneInventoryService {

	public SmartphoneInventoryRepresentation getSmartphoneQtyOnHand(String id);
	public SmartphoneInventoryRepresentation createSmartphoneInventory(SmartphoneInventoryRequest smartphoneInventoryRequest);
	public Response updateSmartphoneInventory(SmartphoneInventoryRequest smartphoneInventoryRequest);
    public Response deleteSmartphoneInventory(String id);
}
