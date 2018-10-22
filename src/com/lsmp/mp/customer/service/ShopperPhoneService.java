package com.lsmp.mp.customer.service;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.customer.service.representation.ShopperPhoneRepresentation;
import com.lsmp.mp.customer.service.representation.ShopperPhoneRequest;

@WebService
public interface ShopperPhoneService {

	public ShopperPhoneRepresentation getShopperPhone(String phoneID);
	public ShopperPhoneRepresentation insertShopperPhone(ShopperPhoneRequest shopperPhoneRequest);
	public Response updateShopperPhone(ShopperPhoneRequest shopperPhoneRequest);
    public Response deleteShopperPhone(String phoneID);
}
