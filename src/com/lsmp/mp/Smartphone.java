package com.lsmp.mp;

import java.util.List;

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
	private List<SmartphoneReview> smartphoneReviews;
		
	public List<SmartphoneReview> getSmartphoneReviews() {
		return smartphoneReviews;
	}
	public void setSmartphoneReviews(List<SmartphoneReview> smartphoneReviews) {
		this.smartphoneReviews = smartphoneReviews;
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
