package com.lsmp.mp.product.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.lsmp.mp.link.AbstractRepresentation;

@XmlRootElement(name = "smartphoneRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class SmartphoneRepresentation extends AbstractRepresentation{

	private String productID;
	private double purchasePrice;
	private double sellingPrice;
	private String displayInch;
	private String brand;
	private String ramSize;
	private String os;
	private String storageSize;
	private String partnerID;
		
	public String getPartnerID() {
		return partnerID;
	}
	public void setPartnerID(String partnerID) {
		this.partnerID = partnerID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
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
