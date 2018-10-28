package com.lsmp.mp.product.service;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.product.service.representation.BookInventoryRepresentation;
import com.lsmp.mp.product.service.representation.BookInventoryRequest;

@WebService
public interface BookInventoryService {

	public BookInventoryRepresentation getBookQtyOnHand(String id);
	public BookInventoryRepresentation createBookInventory(BookInventoryRequest bookInventoryRequest);
	public Response updateBookInventory(BookInventoryRequest bookInventoryRequest);
    public Response deleteBookInventory(String id);
	
}
