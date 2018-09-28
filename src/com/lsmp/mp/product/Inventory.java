package com.lsmp.mp.product;

import java.util.Map;

/**
 * Inventory model class
 * @author samzi
 *
 */

public class Inventory {

	//ProductID and qtyOnHand Map
	private Map<String,Double> qtyOnHandMap;

	public Map<String, Double> getQtyOnHandMap() {
		return qtyOnHandMap;
	}

	public void setQtyOnHandMap(Map<String, Double> qtyOnHandMap) {
		this.qtyOnHandMap = qtyOnHandMap;
	}
	
	
}
