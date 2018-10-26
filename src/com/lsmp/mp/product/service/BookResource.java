package com.lsmp.mp.product.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.lsmp.mp.product.service.representation.BookRepresentation;
import com.lsmp.mp.product.service.workflow.BookActivity;

@Path("/bookservice/")
public class BookResource implements BookService {
	//GET,CREATE,DELETE AND UPDATE A PRODUCT
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/book/{productId}")
	public BookRepresentation getBook(@PathParam("productId") String id) {
		System.out.println("GET METHOD Request from Client with bookRequest String ............." + id);
		BookActivity bookActivity=new BookActivity();
		return bookActivity.getBook(id);
	}
	
	

}
