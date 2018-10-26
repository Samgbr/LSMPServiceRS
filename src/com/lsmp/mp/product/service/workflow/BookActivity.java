package com.lsmp.mp.product.service.workflow;

import com.lsmp.mp.product.ProductManager;
import com.lsmp.mp.product.Book;
//import com.lsmp.mp.product.Product;
import com.lsmp.mp.product.service.representation.BookRepresentation;;

public class BookActivity {
	public static ProductManager productManager=new ProductManager();
	
	public BookRepresentation getBook(String id) {
		
		Book book=productManager.getBook(id);
		
		BookRepresentation bookRepresentation=new BookRepresentation();
		
		bookRepresentation.setProductID(book.getProductID());
		bookRepresentation.setProductName(book.getProductName());
		bookRepresentation.setDescription(book.getDescription());
		bookRepresentation.setPurchasePrice(book.getPurchasePrice());
		bookRepresentation.setSellingPrice(book.getSellingPrice());
		bookRepresentation.setDiscount(book.getDiscount());
		bookRepresentation.setTitle(book.getTitle());
		bookRepresentation.setIsbn(book.getIsbn());
		bookRepresentation.setPublisher(book.getPublisher());
		bookRepresentation.setAuthor(book.getAuthor());
		bookRepresentation.setEdition(book.getEdition());
		bookRepresentation.setBookType(book.getBookType());
		
		
		return bookRepresentation;
	}

}
