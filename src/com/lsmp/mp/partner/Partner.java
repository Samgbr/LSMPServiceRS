package com.lsmp.mp.partner;

import java.util.List;

import com.lsmp.mp.customer.Customer;
import com.lsmp.mp.product.Product;

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
