package com.lsmp.mp.product;

import java.util.Map;

/**
 * Inventory model class
 * @author samzi
 *
 */

public class Inventory {

	//ProductID and qtyOnHand Map
	private String inventoryID;
	private Map<String,Double> qtyOnHandMap;
	private double qty;

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public String getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(String inventoryID) {
		this.inventoryID = inventoryID;
	}

	public Map<String, Double> getQtyOnHandMap() {
		return qtyOnHandMap;
	}

	public void setQtyOnHandMap(Map<String, Double> qtyOnHandMap) {
		this.qtyOnHandMap = qtyOnHandMap;
	}
	
	
}
