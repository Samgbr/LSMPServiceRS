package com.lsmp.mp.partner.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "partnerBillingRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class PartnerBillingRepresentation {

	private String billID;
	private String creditCardNumber;
	private int cvv;
	private int expiryMonth;
	private int expiryYear;
	private String partnerProfileID;
	
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
	public String getPartnerProfileID() {
		return partnerProfileID;
	}
	public void setPartnerProfileID(String partnerProfileID) {
		this.partnerProfileID = partnerProfileID;
	}
	
}
