package com.lsmp.mp.product;

import java.util.Set;

import com.lsmp.mp.product.review.ProductReview;

/**
 * This is a smartphone model class and one of product types
 * @author samzi
 *
 */

public class Smartphone extends Product {

	// attributes
	private String displayInch;
	private String brand;
	private String ramSize;
	private String os;
	private String storageSize;
	private Set<ProductReview> reviews;
	
	public Set<ProductReview> getReviews() {
		return reviews;
	}
	public void setReviews(Set<ProductReview> reviews) {
		this.reviews = reviews;
	}
	public String getDisplayInch() {
		return displayInch;
	}
	public void setDisplayInch(String displayInch) {
		this.displayInch = displayInch;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getRamSize() {
		return ramSize;
	}
	public void setRamSize(String ramSize) {
		this.ramSize = ramSize;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getStorageSize() {
		return storageSize;
	}
	public void setStorageSize(String storageSize) {
		this.storageSize = storageSize;
	}
	
	
}
