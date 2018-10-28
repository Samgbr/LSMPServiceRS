package com.lsmp.mp.product.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.lsmp.mp.product.service.representation.BookInventoryRepresentation;
import com.lsmp.mp.product.service.representation.BookInventoryRequest;
import com.lsmp.mp.product.service.workflow.BookActivity;
import com.lsmp.mp.product.service.workflow.BookInventoryActivity;

@Path("/bookinventoryservice/")
public class BookInventoryResource implements BookInventoryService{

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/bookinventory/{productId}")
	public BookInventoryRepresentation getBookQtyOnHand(@PathParam("productId") String id) {
		System.out.println("GET METHOD Request from Client with Book Inventory Request String ............." + id);
		BookInventoryActivity bookinventoryActivity=new BookInventoryActivity();
		return bookinventoryActivity.getBookQtyOnHand(id);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/bookinventory")
	public BookInventoryRepresentation createBookInventory(BookInventoryRequest bookInventoryRequest) {
		System.out.println("POST METHOD Book Inventory Request from Client with ............." );		
		BookInventoryActivity bookinventoryActivity=new BookInventoryActivity();
		String pid = (String)bookInventoryRequest.getQtyOnHandMap().keySet().toArray()[0];
		return bookinventoryActivity.createBookInventory(bookInventoryRequest.getInventoryID(), pid, bookInventoryRequest.getQtyOnHandMap().get(pid));
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/bookinventory")
	public Response updateBookInventory(BookInventoryRequest bookInventoryRequest) {
		System.out.println("PUT METHOD Book Inventory Request from Client with ............." );		
		BookInventoryActivity bookinventoryActivity=new BookInventoryActivity();
		String pid = (String)bookInventoryRequest.getQtyOnHandMap().keySet().toArray()[0];
		String res = bookinventoryActivity.updateBookInventory(pid, bookInventoryRequest.getQtyOnHandMap().get(pid));
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/bookinventory/{productId}")
	public Response deleteBookInventory(@PathParam("productId") String id) {
		System.out.println("Delete METHOD Request from Client with Book Inventory Request String ............." + id);
		BookInventoryActivity bookinventoryActivity=new BookInventoryActivity();
		String res = bookinventoryActivity.deleteBookInventory(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	
	
}
