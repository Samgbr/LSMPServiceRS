package com.lsmp.mp.product.service.representation;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ProductInventoryRequest {

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
