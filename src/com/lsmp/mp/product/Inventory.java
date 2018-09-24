package com.lsmp.mp.product;

import java.util.Map;

/**
 * Inventory model class
 * @author samzi
 *
 */

public class Inventory {

	private Map<Product,Double> qtyOnHandMap;

	public Map<Product, Double> getQtyOnHandMap() {
		return qtyOnHandMap;
	}

	public void setQtyOnHandMap(Map<Product, Double> qtyOnHandMap) {
		this.qtyOnHandMap = qtyOnHandMap;
	}
	
	
}
