package com.lsmp.mp.customer.service;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.lsmp.mp.customer.service.representation.ShopperPhoneRepresentation;
import com.lsmp.mp.customer.service.representation.ShopperPhoneRequest;

@Path("/shopperphoneservice/")
public class ShopperPhoneResource implements ShopperPhoneService{

	@Override
	public ShopperPhoneRepresentation getShopperPhone(String phoneID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShopperPhoneRepresentation insertShopperPhone(ShopperPhoneRequest shopperPhoneRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response updateShopperPhone(ShopperPhoneRequest shopperPhoneRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteShopperPhone(String phoneID) {
		// TODO Auto-generated method stub
		return null;
	}

}
