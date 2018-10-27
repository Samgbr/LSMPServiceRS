package com.lsmp.mp.customer.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "shopperPhoneRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ShopperPhoneRepresentation {

	private String phoneID;
	private String type;
	private String phoneNumber;
	private String shopperProfileID;
	
	public String getPhoneID() {
		return phoneID;
	}
	public void setPhoneID(String phoneID) {
		this.phoneID = phoneID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getShopperProfileID() {
		return shopperProfileID;
	}
	public void setShopperProfileID(String shopperProfileID) {
		this.shopperProfileID = shopperProfileID;
	}
	
}
