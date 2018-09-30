package com.lsmp.mp.partner;

import com.lsmp.mp.customer.Profile;

/**
 * This is partner model class
 * @author samzi
 *
 */
public class Partner extends Profile{

	//Instances
	private String sellerLevel;
	private String sellerName;
		
	public String getSellerLevel() {
		return sellerLevel;
	}
	public void setSellerLevel(String sellerLevel) {
		this.sellerLevel = sellerLevel;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	
}
