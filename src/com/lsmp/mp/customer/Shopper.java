package com.lsmp.mp.customer;

import java.io.Serializable;
import java.util.Set;

/**
 * This Shopper model class
 * @author samzi
 *
 */
public class Shopper extends Profile implements Serializable {

	private static final long serialVersionUID = 1L;
	//Instances
	private String shopperType;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getShopperType() {
		return shopperType;
	}

	public void setShopperType(String shopperType) {
		this.shopperType = shopperType;
	}	
	
}
