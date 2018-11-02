package com.lsmp.mp.order.service;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.order.service.representation.BookOrderDetailRepresentation;
import com.lsmp.mp.order.service.representation.BookOrderDetailRequest;


@WebService
public interface BookOrderDetailService {

	
	public Set<BookOrderDetailRepresentation> getBookOrderDetails();
	public BookOrderDetailRepresentation getBookOrderDetail(String id);
	public BookOrderDetailRepresentation createBookOrderDetail(BookOrderDetailRequest bookOrderDetailRequest);
	public Response updateBookOrderDetail(BookOrderDetailRequest bookOrderDetailRequest);
    public Response deleteBookOrderDetail(String id);
}
