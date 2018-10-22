package com.lsmp.mp.customer;



/**
 * This phone model class hold customer phone number
 * @author samzi
 *
 */
public class Phone{

	// Instances
	private String phoneID;
	private String type;
	private String phoneNumber;
	private String shopperProfileID;
	private String partnerProfileID;
		
	public String getShopperProfileID() {
		return shopperProfileID;
	}
	public void setShopperProfileID(String shopperProfileID) {
		this.shopperProfileID = shopperProfileID;
	}
	public String getPartnerProfileID() {
		return partnerProfileID;
	}
	public void setPartnerProfileID(String partnerProfileID) {
		this.partnerProfileID = partnerProfileID;
	}
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

	
}
