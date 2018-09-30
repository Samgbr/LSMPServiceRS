package com.lsmp.mp.product;

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
