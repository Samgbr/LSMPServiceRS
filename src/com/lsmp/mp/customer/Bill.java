package com.lsmp.mp.customer;


/**
 * This class is a billing model class 
 * @author samzi
 *
 */
public class Bill{

	private String billID;
	private String creditCardNumber;
	private int cvv;
	private int expiryMonth;
	private int expiryYear;
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
	public String getBillID() {
		return billID;
	}
	public void setBillID(String billID) {
		this.billID = billID;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public int getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public int getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}
	
	
}
