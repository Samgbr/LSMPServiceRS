package com.lsmp.mp.product.service.workflow;

import com.lsmp.mp.product.Inventory;
import com.lsmp.mp.product.ProductManager;
import com.lsmp.mp.product.service.representation.BookInventoryRepresentation;

public class BookInventoryActivity {

public static ProductManager productManager=new ProductManager();
	
	public BookInventoryRepresentation getBookQtyOnHand(String id) {
		
		Inventory inventory=productManager.getBookQtyOnHand(id);
		
		BookInventoryRepresentation bookInventoryRepresentation=new BookInventoryRepresentation();
		
		bookInventoryRepresentation.setQtyOnHandMap(inventory.getQtyOnHandMap());
		bookInventoryRepresentation.setInventoryID(inventory.getInventoryID());
		
		return bookInventoryRepresentation;
	}
	
	public String deleteBookInventory(String id) {
		productManager.deleteBookQtyOnHand(id);
		return "OK";
	}

	public BookInventoryRepresentation createBookInventory(String iid, String bid, double qtyOnHand) {
		
		Inventory inventory = productManager.addBookQtyOnHand(iid, bid, qtyOnHand);
		
		BookInventoryRepresentation bookInventoryRepresentation=new BookInventoryRepresentation();
        
		bookInventoryRepresentation.setQtyOnHandMap(inventory.getQtyOnHandMap());
		bookInventoryRepresentation.setInventoryID(iid);
		
		return bookInventoryRepresentation;
	}

	public String updateBookInventory(String id, double qtyOnHand) {
		
		productManager.updateBookQtyOnHand(id, qtyOnHand);
		
		return "OK";
	}
}
