package com.lsmp.mp.product.service.representation;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "smartphoneInventoryRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class SmartphoneInventoryRepresentation {

	private Map<String,Double> qtyOnHandMap;

	public Map<String, Double> getQtyOnHandMap() {
		return qtyOnHandMap;
	}

	public void setQtyOnHandMap(Map<String, Double> qtyOnHandMap) {
		this.qtyOnHandMap = qtyOnHandMap;
	}
	
}
