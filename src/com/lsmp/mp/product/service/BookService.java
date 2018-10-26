package com.lsmp.mp.product.service;

import javax.jws.WebService;

import com.lsmp.mp.product.service.representation.BookRepresentation;



@WebService
public interface BookService {
	
	public BookRepresentation getBook(String productId);

}
