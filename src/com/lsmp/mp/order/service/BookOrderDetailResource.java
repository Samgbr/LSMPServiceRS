package com.lsmp.mp.order.service;

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

import com.lsmp.mp.order.service.representation.BookOrderDetailRepresentation;
import com.lsmp.mp.order.service.representation.BookOrderDetailRequest;
import com.lsmp.mp.order.service.workflow.BookOrderDetailActivity;

@Path("/bookorderdetailservice/")
public class BookOrderDetailResource implements BookOrderDetailService{

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/bookorderdetails")
	public Set<BookOrderDetailRepresentation> getBookOrderDetails() {
		System.out.println("GET METHOD Request for all Book Order Details .............");
		BookOrderDetailActivity bookOrderDetailActivity = new BookOrderDetailActivity();
		return bookOrderDetailActivity.getBookOrderDetails();
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/bookorderdetail/{oderDetailId}")
	public BookOrderDetailRepresentation getBookOrderDetail(@PathParam("oderDetailId") String id) {
		System.out.println("GET METHOD Request from Client with Book Order Detail Request String ............." + id);
		BookOrderDetailActivity bookOrderDetailActivity = new BookOrderDetailActivity();
		return bookOrderDetailActivity.getBookOrderDetail(id);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/bookorderdetail")
	public BookOrderDetailRepresentation createBookOrderDetail(BookOrderDetailRequest bookOrderDetailRequest) {
		System.out.println("POST METHOD Book Order Detail Request from Client with ............." );		
		BookOrderDetailActivity bookOrderDetailActivity = new BookOrderDetailActivity();
		return bookOrderDetailActivity.createBookOrderDetail(bookOrderDetailRequest.getOrderDetailID(), bookOrderDetailRequest.getOrderID()
				, bookOrderDetailRequest.getBookProductID(), bookOrderDetailRequest.getOrderedQuantity());
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/bookorderdetail")
	public Response updateBookOrderDetail(BookOrderDetailRequest bookOrderDetailRequest) {
		System.out.println("PUT METHOD Book Order Detail Request from Client with ............." );		
		BookOrderDetailActivity bookOrderDetailActivity = new BookOrderDetailActivity();
		String res = bookOrderDetailActivity.updateBookOrderDetail(bookOrderDetailRequest.getOrderDetailID(), bookOrderDetailRequest.getOrderID()
				, bookOrderDetailRequest.getBookProductID(), bookOrderDetailRequest.getOrderedQuantity());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/bookorderdetail/{oderDetailId}")
	public Response deleteBookOrderDetail(@PathParam("oderDetailId") String id) {
		System.out.println("Delete METHOD Request from Client with Book Order Detail Request String ............." + id);
		BookOrderDetailActivity bookOrderDetailActivity = new BookOrderDetailActivity();
		String res = bookOrderDetailActivity.deleteBookOrderDetail(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	

}
