package com.lsmp.mp.customer.service;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.customer.service.representation.ShopperBillingRepresentation;
import com.lsmp.mp.customer.service.representation.ShopperBillingRequest;

@WebService
public interface ShopperBillingService {

	public Set<ShopperBillingRepresentation> getShopperBillingInfos(String id);
	public ShopperBillingRepresentation getShopperBillingInfo(String billID);
	public ShopperBillingRepresentation insertShopperBillingInfo(ShopperBillingRequest shopperBillingRequest);
	public Response updateShopperBillingInfo(ShopperBillingRequest ShopperBillingRequest);
    public Response deleteShopperBillingInfo(String billID);
}
