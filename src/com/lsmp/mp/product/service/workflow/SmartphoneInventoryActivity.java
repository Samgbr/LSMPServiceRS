package com.lsmp.mp.product.service.workflow;

import com.lsmp.mp.product.Inventory;
import com.lsmp.mp.product.ProductManager;
import com.lsmp.mp.product.service.representation.SmartphoneInventoryRepresentation;

public class SmartphoneInventoryActivity {

public static ProductManager productManager=new ProductManager();
	
	public SmartphoneInventoryRepresentation getSmartphoneQtyOnHand(String id) {
		
		Inventory inventory=productManager.getSmartphoneQtyOnHand(id);
		
		SmartphoneInventoryRepresentation smartphoneInventoryRepresentation=new SmartphoneInventoryRepresentation();
		
		smartphoneInventoryRepresentation.setQtyOnHandMap(inventory.getQtyOnHandMap());
		smartphoneInventoryRepresentation.setInventoryID(inventory.getInventoryID());
		
		return smartphoneInventoryRepresentation;
	}
	
	public String deleteSmartphoneInventory(String id) {
		productManager.deleteSmartphoneQtyOnHand(id);
		return "OK";
	}

	public SmartphoneInventoryRepresentation createSmartphoneInventory(String iid, String spid, double qtyOnHand) {
		
		Inventory inventory = productManager.addSmartphoneQtyOnHand(iid, spid, qtyOnHand);
		
		SmartphoneInventoryRepresentation smartphoneInventoryRepresentation=new SmartphoneInventoryRepresentation();
        
		smartphoneInventoryRepresentation.setQtyOnHandMap(inventory.getQtyOnHandMap());
		smartphoneInventoryRepresentation.setInventoryID(iid);
		
		return smartphoneInventoryRepresentation;
	}

	public String updateSmartphoneInventory(String id, double qtyOnHand) {
		
		productManager.updateSmartphoneQtyOnHand(id, qtyOnHand);
		
		return "OK";
	}
}
