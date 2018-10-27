package com.lsmp.mp.customer.service;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.customer.service.representation.ShopperPhoneRepresentation;
import com.lsmp.mp.customer.service.representation.ShopperPhoneRequest;

@WebService
public interface ShopperPhoneService {

	public Set<ShopperPhoneRepresentation> getShopperPhones(String id);
	public ShopperPhoneRepresentation getShopperPhone(String id);
	public ShopperPhoneRepresentation insertShopperPhone(ShopperPhoneRequest shopperPhoneRequest);
	public Response updateShopperPhone(ShopperPhoneRequest shopperPhoneRequest);
    public Response deleteShopperPhone(String phoneID);
}
