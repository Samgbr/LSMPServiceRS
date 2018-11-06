package com.lsmp.mp.product.service.workflow;

import com.lsmp.mp.product.ProductManager;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.mp.product.Book;
//import com.lsmp.mp.product.Product;
import com.lsmp.mp.product.service.representation.BookRepresentation;
import com.lsmp.mp.product.service.representation.Link;;

public class BookActivity {
	
	public static ProductManager productManager=new ProductManager();
	
	public BookRepresentation getBook(String id) {
		
		Book book=productManager.getBook(id);
		
		BookRepresentation bookRepresentation=new BookRepresentation();
		
		bookRepresentation.setProductID(book.getProductID());
		bookRepresentation.setPurchasePrice(book.getPurchasePrice());
		bookRepresentation.setSellingPrice(book.getSellingPrice());
		bookRepresentation.setTitle(book.getTitle());
		bookRepresentation.setIsbn(book.getIsbn());
		bookRepresentation.setPublisher(book.getPublisher());
		bookRepresentation.setAuthor(book.getAuthor());
		bookRepresentation.setEdition(book.getEdition());
		bookRepresentation.setPartnerID(book.getPartnerID());
		
		setLinks(bookRepresentation);
		
		return bookRepresentation;
	}
	
	private void setLinks(BookRepresentation bookRepresentation) {
		
		// Set up the activities that can be performed on orders
		Link buy = new Link("Buy", 
				"http://localhost:8082/Order/orderservice/order","application/xml");
		
		bookRepresentation.setLinks(buy);
	}

	public Set<BookRepresentation> getBooks() {
		
		Set<Book> books = new HashSet<Book>();
		Set<BookRepresentation> bookRepresentations = new HashSet<BookRepresentation>();
		
		books = productManager.getAllBooks();
		
		Iterator<Book> it = books.iterator();
		while(it.hasNext()) {
          
			Book book = (Book)it.next();
          
          BookRepresentation bookRepresentation=new BookRepresentation();
          
          bookRepresentation.setProductID(book.getProductID());
  		  bookRepresentation.setPurchasePrice(book.getPurchasePrice());
  		  bookRepresentation.setSellingPrice(book.getSellingPrice());
  		  bookRepresentation.setTitle(book.getTitle());
  		  bookRepresentation.setIsbn(book.getIsbn());
  		  bookRepresentation.setPublisher(book.getPublisher());
  		  bookRepresentation.setAuthor(book.getAuthor());
  		  bookRepresentation.setEdition(book.getEdition());
  		  bookRepresentation.setPartnerID(book.getPartnerID());
  		  
          //now add this representation in the list
  		bookRepresentations.add(bookRepresentation);
        }
		return bookRepresentations;
	}

	public String deletebook(String id) {
		productManager.deleteBook(id);
		return "OK";
	}

	public BookRepresentation createBook(String productID, double purchasePrice, double sellingPrice, String title,
			String isbn, String publisher, String author, String edition, String partnerID) {
		
		Book book = productManager.addBook(productID, isbn, publisher, author, edition, null, null, null, purchasePrice, sellingPrice, 0.0, title,partnerID);
		
		BookRepresentation bookRepresentation=new BookRepresentation();
        
		bookRepresentation.setProductID(book.getProductID());
		bookRepresentation.setPurchasePrice(book.getPurchasePrice());
		bookRepresentation.setSellingPrice(book.getSellingPrice());
		bookRepresentation.setTitle(book.getTitle());
		bookRepresentation.setIsbn(book.getIsbn());
		bookRepresentation.setPublisher(book.getPublisher());
		bookRepresentation.setAuthor(book.getAuthor());
		bookRepresentation.setEdition(book.getEdition());
		bookRepresentation.setPartnerID(book.getPartnerID());
		
		return bookRepresentation;
	}

	public String updateBook(String productID, double purchasePrice, double sellingPrice, String title, String isbn,
			String publisher, String author, String edition, String partnerID) {
		
		productManager.updateBook(productID, isbn, publisher, author, edition, null, null, null, purchasePrice, sellingPrice, 0.0, title, partnerID);
		
		return "OK";
	}

}
