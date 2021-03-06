package com.lsmp.mp.product.service.workflow;

import com.lsmp.mp.link.Link;
import com.lsmp.mp.product.Inventory;
import com.lsmp.mp.product.ProductManager;
import com.lsmp.mp.product.service.representation.ProductInventoryRepresentation;

public class ProductInventoryActivity {

	public static ProductManager productManager=new ProductManager();
	
	public ProductInventoryRepresentation getProductQtyOnHand(String id) {
		
		Inventory inventory=productManager.getProductQtyOnHand(id);
		
		ProductInventoryRepresentation productInventoryRepresentation=new ProductInventoryRepresentation();
		
		productInventoryRepresentation.setQtyOnHandMap(inventory.getQtyOnHandMap());
		productInventoryRepresentation.setInventoryID(inventory.getInventoryID());
		productInventoryRepresentation.setQty(inventory.getQty());
		
		setLinks(productInventoryRepresentation);
		
		return productInventoryRepresentation;
	}
	
	private void setLinks(ProductInventoryRepresentation productInventoryRepresentation) {
		// Set up the activities that can be performed on orders
		Link buy = new Link("buy", 
			"http://localhost:8082/Order/orderservice/order" ,"application/xml");
				
		productInventoryRepresentation.setLinks(buy);
	}

	public String deleteProductInventory(String id) {
		productManager.deleteProductQtyOnHand(id);
		return "OK";
	}

	public ProductInventoryRepresentation createProductInventory(String iid, String bid, double qtyOnHand) {
		
		Inventory inventory = productManager.addProductQtyOnHand(iid, bid, qtyOnHand);
		
		ProductInventoryRepresentation productInventoryRepresentation=new ProductInventoryRepresentation();
        
		productInventoryRepresentation.setQtyOnHandMap(inventory.getQtyOnHandMap());
		productInventoryRepresentation.setInventoryID(iid);
		
		return productInventoryRepresentation;
	}

	public String updateProductInventory(String id, double qtyOnHand) {
		
		productManager.updateProductQtyOnHand(id, qtyOnHand);
		
		return "OK";
	}
}
