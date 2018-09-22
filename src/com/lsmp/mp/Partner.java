package com.lsmp.mp;

import java.util.List;

/**
 * This is partner model class
 * @author samzi
 *
 */
public class Partner extends Customer{

	//Instances
	private String sellerLevel;
	private String sellerName;
	private List<Product> products;
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
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
