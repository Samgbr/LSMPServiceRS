package com.lsmp.mp.product.service;

import java.util.Set;

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

import com.lsmp.mp.product.service.representation.BookRepresentation;
import com.lsmp.mp.product.service.representation.BookRequest;
import com.lsmp.mp.product.service.workflow.BookActivity;

@Path("/bookservice/")
public class BookResource implements BookService {
	//GET,CREATE,DELETE AND UPDATE A PRODUCT
	
	@GET
	@Produces({"application/json"})
	@Path("/book/{productId}")
	public BookRepresentation getBook(@PathParam("productId") String id) {
		System.out.println("GET METHOD Request from Client with book Request String ............." + id);
		BookActivity bookActivity=new BookActivity();
		return bookActivity.getBook(id);
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/books")
	public Set<BookRepresentation> getBooks() {
		System.out.println("GET METHOD Request for all Books .............");
		BookActivity bookActivity=new BookActivity();
		return bookActivity.getBooks();
	}

	@POST
	@Produces({"application/json"})
	@Consumes({"application/json"})
	@Path("/book")
	public BookRepresentation createBook(BookRequest bookRequest) {
		System.out.println("POST METHOD Book Request from Client with ............." );		
		BookActivity bookActivity=new BookActivity();
		return bookActivity.createBook(bookRequest.getPurchasePrice(),bookRequest.getSellingPrice()
				, bookRequest.getTitle(), bookRequest.getIsbn(), bookRequest.getPublisher(), bookRequest.getAuthor()
				, bookRequest.getEdition(),bookRequest.getPartnerID());
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/book")
	public Response updateBook(BookRequest bookRequest) {
		System.out.println("PUT METHOD Book Request from Client with ............." );		
		BookActivity bookActivity=new BookActivity();
		String res = bookActivity.updateBook(bookRequest.getProductID(),bookRequest.getPurchasePrice(),bookRequest.getSellingPrice()
				, bookRequest.getTitle(), bookRequest.getIsbn(), bookRequest.getPublisher(), bookRequest.getAuthor()
				, bookRequest.getEdition(),bookRequest.getPartnerID());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/book/{productId}")
	public Response deleteBook(@PathParam("productId") String id) {
		System.out.println("Delete METHOD Request from Client with Book Request String ............." + id);
		BookActivity bookActivity=new BookActivity();
		String res = bookActivity.deletebook(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	
	

}
