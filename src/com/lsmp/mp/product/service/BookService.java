package com.lsmp.mp.product.service;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.lsmp.mp.product.service.representation.BookRepresentation;
import com.lsmp.mp.product.service.representation.BookRequest;



@WebService
public interface BookService {
	
	public BookRepresentation getBook(String id);
	public Set<BookRepresentation> getBooks();
	public BookRepresentation createBook(BookRequest bookRequest);
	public Response updateBook(BookRequest bookRequest);
    public Response deleteBook(String id);

}
