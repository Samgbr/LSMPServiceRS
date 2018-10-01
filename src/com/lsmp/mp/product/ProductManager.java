package com.lsmp.mp.product;

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
	
	public Book addBook(String productID, String isbn, String publisher, String author, String edition, 
			String booktype, String productName, String description, double purchasePrice, double sellingPrice, double discount,String title) {
		
		Book book = bDAO.addBook(productID, productName, description, purchasePrice, sellingPrice, discount, title, isbn, publisher, author, edition, booktype);
		
		return book;
	}

	public void updateBook(String id, String productName, String description, double purchasePrice, double sellingPrice, 
			double discount, String title, String isbn, String publisher, String author, String edition, String bookType) {
		
		bDAO.updateBook(id, productName, description, purchasePrice, sellingPrice, discount, title, isbn, publisher, author, edition, bookType);
	}

	public void deleteBook(String id) {
		bDAO.deleteBook(id);
	}
	
	
	public Smartphone getSmartphone(String id) {
		return spDAO.getSmartphone(id);
	}
	
	public Smartphone addSmartphone(String productName, String description, double purchasePrice, double sellingPrice, 
			double discount, String displayInch, String brand, String ramSize, String os, String storageSize) {
		
		Smartphone smartphone = spDAO.addSmartphone(productName, description, purchasePrice, sellingPrice, discount, displayInch, brand, ramSize, os, storageSize);
		
		return smartphone;
	}

	public void updateSmartphone(String id, String productName, String description, double purchasePrice, double sellingPrice, 
			double discount, String displayInch, String brand, String ramSize, String os, String storageSize) {
		
		spDAO.updateSmartphone(id, productName, description, purchasePrice, sellingPrice, discount, displayInch, brand, ramSize, os, storageSize);
	}

	public void deleteSmartphone(String id) {
		spDAO.deleteSmartphone(id);
	}
	
	public Inventory getProductQtyOnHand(String id) {
		return iDAO.getProductQtyOnHand(id);
	}
	
	public Inventory addProductQtyOnHand(String iid, String id, double qtyOnHand) {
		
		Inventory inventory = iDAO.addProductQtyOnHand(iid, id, qtyOnHand);
		
		return inventory;
	}

	public void updateProductQtyOnHand(String id, double qtyOnHand) {
		
		iDAO.updateProductQtyOnHand(id, qtyOnHand);
	}

	public void deleteProductQtyOnHand(String id) {
		iDAO.deleteProductQtyOnHand(id);
	}
}
