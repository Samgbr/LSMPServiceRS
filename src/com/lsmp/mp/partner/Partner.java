package com.lsmp.mp.partner;

import java.util.Set;

import com.lsmp.mp.customer.Profile;
import com.lsmp.mp.product.Product;

/**
 * This is partner model class
 * @author samzi
 *
 */
public class Partner extends Profile{

	//Instances
	private String sellerLevel;
	private String sellerName;
	private Set<Product> products;
		
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
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
