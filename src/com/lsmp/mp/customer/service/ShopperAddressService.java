package com.lsmp.mp.customer.service;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.customer.service.representation.ShopperAddressRepresentation;
import com.lsmp.mp.customer.service.representation.ShopperAddressRequest;

@WebService
public interface ShopperAddressService {

	//Address representation and request methods goes here
		public ShopperAddressRepresentation getShopperAddress(String addressID);
		public ShopperAddressRepresentation createShopperAddress(ShopperAddressRequest shopperAddressRequest);
		public Response updateShopperAddress(ShopperAddressRequest addressRequest);
	    public Response deleteShopperAddress(String addressId);
}
