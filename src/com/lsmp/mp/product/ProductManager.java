package com.lsmp.mp.product;

import java.util.Set;

import com.lsmp.dal.product.BookDAO;
import com.lsmp.dal.product.InventoryDAO;
import com.lsmp.dal.product.SmartphoneDAO;

public class ProductManager {
	
private static BookDAO bDAO = new BookDAO();
private static SmartphoneDAO spDAO = new SmartphoneDAO();
private static InventoryDAO iDAO = new InventoryDAO();
	
	public Book getBook(String id) {
		return bDAO.getBook(id);
	}
	
	public Set<Book> getAllBooks() {
		return bDAO.getAllBooks();
	}
	
	public Book addBook(String isbn, String publisher, String author, String edition, 
			String booktype, String productName, String description, double purchasePrice, double sellingPrice, double discount,String title, String partnerID) {
		
		Book book = bDAO.addBook(productName, description, purchasePrice, sellingPrice, discount, title, isbn, publisher, author, edition, booktype,partnerID);
		
		return book;
	}

	public void updateBook(String productID, String isbn, String publisher, String author, String edition, 
			String booktype, String productName, String description, double purchasePrice, double sellingPrice, double discount,String title, String partnerID) {
		
		bDAO.updateBook(productID, productName, description, purchasePrice, sellingPrice, discount, title, isbn, publisher, author, edition, booktype,partnerID);
	}

	public void deleteBook(String id) {
		bDAO.deleteBook(id);
	}
	
	
	public Smartphone getSmartphone(String id) {
		return spDAO.getSmartphone(id);
	}
	
	public Set<Smartphone> getAllSmartphones() {
		return spDAO.getAllSmartphones();
	}
	
	public Smartphone addSmartphone(String id, String productName, String description, double purchasePrice, double sellingPrice, 
			double discount, String displayInch, String brand, String ramSize, String os, String storageSize, String partnerID) {
		
		Smartphone smartphone = spDAO.addSmartphone(id, productName, description, purchasePrice, sellingPrice, discount, displayInch, brand, ramSize, os, storageSize,partnerID);
		
		return smartphone;
	}

	public void updateSmartphone(String id, String productName, String description, double purchasePrice, double sellingPrice, 
			double discount, String displayInch, String brand, String ramSize, String os, String storageSize, String partnerID) {
		
		spDAO.updateSmartphone(id, productName, description, purchasePrice, sellingPrice, discount, displayInch, brand, ramSize, os, storageSize, partnerID);
	}

	public void deleteSmartphone(String id) {
		spDAO.deleteSmartphone(id);
	}
	
	public Inventory getProductQtyOnHand(String id) {
		return iDAO.getProductQtyOnHand(id);
	}
	
	public Inventory addProductQtyOnHand(String iid, String bid, double qtyOnHand) {
		
		Inventory inventory = iDAO.addProductQtyOnHand(iid, bid, qtyOnHand);
		
		return inventory;
	}

	public void updateProductQtyOnHand(String id, double qtyOnHand) {
		
		iDAO.updateProductQtyOnHand(id, qtyOnHand);
	}

	public void deleteProductQtyOnHand(String id) {
		iDAO.deleteProductQtyOnHand(id);
	}
}
