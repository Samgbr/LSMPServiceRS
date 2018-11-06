package com.lsmp.mp.product.service;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.product.service.representation.ProductInventoryRepresentation;
import com.lsmp.mp.product.service.representation.ProductInventoryRequest;

@WebService
public interface ProductInventoryService {

	public ProductInventoryRepresentation getProductQtyOnHand(String id);
	public ProductInventoryRepresentation createProductInventory(ProductInventoryRequest productInventoryRequest);
	public Response updateProductInventory(ProductInventoryRequest productInventoryRequest);
    public Response deleteProductInventory(String id);
	
}
